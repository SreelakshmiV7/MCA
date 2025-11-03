import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import os
import io

# ✅ Define your base path (where your script and dataset are)
base_path = r"D:\MCA\DM\assignment"

# ✅ Define path for image folder
img_folder = os.path.join(base_path, "img")

# ✅ Create img folder if it doesn’t exist
if not os.path.exists(img_folder):
    os.makedirs(img_folder)
    print(f"📁 Created folder: {img_folder}")
else:
    print(f"📂 Using existing folder: {img_folder}")

# ✅ Load dataset safely
csv_path = os.path.join(base_path, "superstore.csv")
df = pd.read_csv(csv_path, encoding='latin1')
print("✅ Dataset loaded successfully!")

# ✅ Helper function to save DataFrame as image
def save_df_as_image(dataframe, filename, title=""):
    full_path = os.path.join(img_folder, filename)
    fig, ax = plt.subplots(figsize=(10, len(dataframe) * 0.3 + 1))
    ax.axis('tight')
    ax.axis('off')
    table = ax.table(cellText=dataframe.values,
                     colLabels=dataframe.columns,
                     cellLoc='center',
                     loc='center')
    table.auto_set_font_size(False)
    table.set_fontsize(8)
    table.scale(1, 1.2)
    plt.title(title, fontsize=12, pad=10)
    plt.savefig(full_path, bbox_inches='tight', dpi=300)
    plt.close()
    print(f"🖼️ Saved image: {filename}")

# =====================================================
# 📊 DATA ANALYSIS SECTION (All outputs go to /img)
# =====================================================

# 1️⃣ Full Dataset (first 20 rows)
save_df_as_image(df.head(20), "output_full_dataset.png", "Full Dataset (First 20 Rows)")

# 2️⃣ Dataset Info (as image)
buffer = io.StringIO()
df.info(buf=buffer)
info_text = buffer.getvalue()
plt.figure(figsize=(8, 4))
plt.text(0, 1, info_text, fontsize=10, va='top', family='monospace')
plt.axis('off')
plt.savefig(os.path.join(img_folder, "output_info.png"), bbox_inches='tight', dpi=300)
plt.close()
print("🖼️ Saved image: output_info.png")

# 3️⃣ Statistical Summary
save_df_as_image(df.describe().round(2), "output_statistical_summary.png", "Statistical Summary")

# 4️⃣ Null Values
save_df_as_image(df.isnull().sum().reset_index().rename(columns={'index': 'Column', 0: 'Null Count'}),
                 "output_null_values.png", "Null Values per Column")

# 5️⃣ Percentage of Null Values
null_percent = (df.isnull().sum() / len(df) * 100).reset_index()
null_percent.columns = ['Column', 'Null %']
save_df_as_image(null_percent, "output_null_percentage.png", "Percentage of Null Values")

# 6️⃣ Unique Values
unique_vals = df.nunique().reset_index()
unique_vals.columns = ['Column', 'Unique Count']
save_df_as_image(unique_vals, "output_unique_values.png", "Unique Values per Column")

# 7️⃣ Data Types
dtypes_df = df.dtypes.reset_index()
dtypes_df.columns = ['Column', 'Data Type']
save_df_as_image(dtypes_df, "output_data_types.png", "Data Types per Column")

# 8️⃣ Fill Missing Values
for col in df.columns:
    if df[col].dtype in ['float64', 'int64']:
        df[col].fillna(df[col].mean(), inplace=True)
save_df_as_image(df.head(10), "output_filled_values.png", "After Filling Missing Values")

# 9️⃣ Sort by third column
third_col = df.columns[2]
df_sorted = df.sort_values(by=third_col)
save_df_as_image(df_sorted.head(15), "output_sorted.png", f"Sorted by {third_col}")

# 🔟 Rename second column
second_col = df.columns[1]
df.rename(columns={second_col: second_col + "_new"}, inplace=True)
save_df_as_image(df.head(10), "output_renamed.png", f"Renamed Column '{second_col}' to '{second_col}_new'")

# 11️⃣ Categorical & Numerical Columns
cat_cols = df.select_dtypes(include=['object']).columns.tolist()
num_cols = df.select_dtypes(include=['int64', 'float64']).columns.tolist()
cat_df = pd.DataFrame({'Categorical Columns': cat_cols})
num_df = pd.DataFrame({'Numerical Columns': num_cols})
save_df_as_image(cat_df, "output_categorical_cols.png", "Categorical Columns")
save_df_as_image(num_df, "output_numerical_cols.png", "Numerical Columns")

# 12️⃣ Remove Outliers
if len(num_cols) > 0:
    Q1 = df[num_cols].quantile(0.25)
    Q3 = df[num_cols].quantile(0.75)
    IQR = Q3 - Q1
    df_no_outliers = df[~((df[num_cols] < (Q1 - 1.5 * IQR)) | (df[num_cols] > (Q3 + 1.5 * IQR))).any(axis=1)]
    save_df_as_image(df_no_outliers.head(15), "output_no_outliers.png", "After Removing Outliers")

print("\n✅ All outputs saved inside the /img folder successfully!")
