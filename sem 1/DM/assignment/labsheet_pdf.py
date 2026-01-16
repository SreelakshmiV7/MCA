import pandas as pd
import matplotlib.pyplot as plt
from reportlab.lib.pagesizes import A4
from reportlab.lib import colors
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.units import inch
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image, PageBreak
from reportlab.lib.utils import ImageReader
import os

# === CONFIG ===
csv_file = r"D:\MCA\DM\assignment\healthcare-dataset-stroke-data.csv"  # Your dataset file
# Updated output paths
assignment_folder = r"D:\MCA\DM\assignment"
img_folder = os.path.join(assignment_folder, "img")
pdf_file_name = "Dataset_Report.pdf"

# Create folders if they don't exist
os.makedirs(img_folder, exist_ok=True)  # Creates img folder inside assignment
os.makedirs(img_folder, exist_ok=True)  # Ensure outputs subfolder exists (for images)

# === Load Dataset ===
df = pd.read_csv(csv_file)

# Helper: Save dataframe or plot as image
def save_df_as_image(df, filename, title=None, max_rows=15):
    # Limit large datasets for better view
    display_df = df.head(max_rows) if len(df) > max_rows else df
    
    # Calculate figure width based on number of columns to make cells wider
    n_cols = len(display_df.columns)
    fig_width = max(8, n_cols * 1.5)  # Adjust multiplier as needed (e.g., 1.5 inches per column)
    
    fig, ax = plt.subplots(figsize=(fig_width, 3))
    ax.axis("off")
    
    # Calculate equal column widths for the table
    col_widths = [1.0 / n_cols] * n_cols  # Equal width for all columns

    table = ax.table(
        cellText=display_df.values,
        colLabels=display_df.columns,
        loc="center",
        cellLoc="center",
        colWidths=col_widths  # 👈 This sets the width of each cell
    )
    table.auto_set_font_size(False)
    table.set_fontsize(7)
    table.scale(1, 1.3)
    plt.tight_layout()
    img_path = os.path.join(img_folder, filename)  # Save images in img folder
    plt.subplots_adjust(top=1, bottom=0, left=0, right=1)
    plt.savefig(img_path, bbox_inches="tight", dpi=200)
    plt.close()
    return img_path


# === Stepwise Outputs ===
images = []

# 1. Entire dataset
images.append((save_df_as_image(df, "01_entire_dataset.png", "Entire Dataset"), "Figure 1: Entire Dataset"))

# 2. Dataset size
size_img = os.path.join(img_folder, "02_size.png")
plt.figure(figsize=(3, 1))
plt.text(0.1, 0.5, f"Dataset Size: {df.shape}", fontsize=10)
plt.axis("off")
plt.savefig(size_img, bbox_inches="tight", dpi=200)
plt.close()
images.append((size_img, "Figure 2: Size of the Dataset"))

# 3. First 10 rows
images.append((save_df_as_image(df.head(10), "03_first10.png", "First 10 Rows"), "Figure 3: First 10 Rows of Dataset"))

# 4. Last 10 rows
images.append((save_df_as_image(df.tail(10), "04_last10.png", "Last 10 Rows"), "Figure 4: Last 10 Rows of Dataset"))

# 5. Dataset Info
from io import StringIO

buf = StringIO()
df.info(buf=buf)
info_text = buf.getvalue()

info_img = os.path.join(img_folder, "05_info.png")
plt.figure(figsize=(7, 2))
plt.axis("off")
plt.text(0, 1, info_text, fontsize=7, va="top", wrap=True)
plt.savefig(info_img, bbox_inches="tight", dpi=200)
plt.close()
images.append((info_img, "Figure 5: Dataset Information"))

# 6. Statistical View
stat_df = df.describe().round(4).reset_index().rename(columns={"index": "Statistic"})
images.append((save_df_as_image(stat_df, "06_stat.png", "Statistical Summary"), "Figure 6: Statistical View of Dataset"))

# 7. Data types
types_img = save_df_as_image(pd.DataFrame(df.dtypes, columns=["Data Type"]).reset_index().rename(columns={"index": "Column"}),
                             "07_dtypes.png", "Data Types")
images.append((types_img, "Figure 7: Data Types of Dataset Columns"))

# 8. Null Values
null_img = save_df_as_image(df.isnull().sum().to_frame("Null Count").reset_index().rename(columns={"index": "Column"}),
                            "08_nulls.png", "Null Values in Each Column")
images.append((null_img, "Figure 8: Null Values per Column"))

# 9. Unique Values
unique_img = save_df_as_image(df.nunique().to_frame("Unique Count").reset_index().rename(columns={"index": "Column"}),
                              "09_unique.png", "Unique Values in Dataset")
images.append((unique_img, "Figure 9: Number of Unique Values per Column"))

# 10. % of Nulls
null_perc = (df.isnull().sum() / len(df)) * 100
nullperc_img = save_df_as_image(null_perc.to_frame("% Nulls").reset_index().rename(columns={"index": "Column"}),
                                "10_nullperc.png", "Percentage of Null Values per Column")
images.append((nullperc_img, "Figure 10: Percentage of Null Values per Column"))

# 11. Fill Missing Values with Mean
df_filled = df.fillna(df.mean(numeric_only=True))
images.append((save_df_as_image(df_filled, "11_filled.png", "After Filling Missing Values with Mean"),
               "Figure 11: Dataset After Filling Missing Values with Mean"))

# 12. Sort by 3rd column
third_col = df.columns[2]
sorted_df = df.sort_values(by=third_col)
images.append((save_df_as_image(sorted_df, "12_sorted.png", f"Dataset Sorted by '{third_col}'"),
               f"Figure 12: Dataset Sorted by Third Column ({third_col})"))

# 13. Rename 2nd column
second_col = df.columns[1]
df_renamed = df.rename(columns={second_col: f"{second_col}_new"})
images.append((save_df_as_image(df_renamed, "13_renamed.png", "After Renaming Second Column"),
               f"Figure 13: Renamed Column '{second_col}' → '{second_col}_new'"))

# 14. Categorical and Numerical Columns
categorical = df.select_dtypes(include="object").columns.tolist()
numerical = df.select_dtypes(exclude="object").columns.tolist()
cat_num_img = os.path.join(img_folder, "14_catnum.png")
plt.figure(figsize=(5, 2))
plt.axis("off")
plt.text(0.01, 0.8, f"Categorical Columns:\n{categorical}\n\nNumerical Columns:\n{numerical}", fontsize=8)
plt.savefig(cat_num_img, bbox_inches="tight", dpi=200)
plt.close()
images.append((cat_num_img, "Figure 14: Categorical and Numerical Columns"))

# 15. Drop Outliers (numeric columns only)
numeric_df = df.select_dtypes(include=["number"])
Q1 = numeric_df.quantile(0.25)
Q3 = numeric_df.quantile(0.75)
IQR = Q3 - Q1
filtered_df = df[~((numeric_df < (Q1 - 1.5 * IQR)) | (numeric_df > (Q3 + 1.5 * IQR))).any(axis=1)]
# Calculate new dataset shape
new_shape = filtered_df.shape
# Create image for filtered dataset
outlier_img = save_df_as_image(filtered_df, "15_outliers_removed.png", "After Dropping Outliers")
# Append to image list with shape info in caption
images.append(
    (outlier_img,
     f"Figure 15: Dataset After Dropping Outliers (New Shape: {new_shape[0]} rows × {new_shape[1]} columns)")
)



from reportlab.lib.pagesizes import landscape
from reportlab.pdfgen import canvas
from reportlab.lib.units import inch as INCH
from reportlab.lib.colors import black
from PIL import Image
import os

def save_images_to_compact_pdf(image_list, output_pdf):
    """
    Creates a compact, visual-heavy PDF:
    - Packs up to 4 figures per page with captions.
    - Automatically resizes images to fit cleanly.
    - Keeps minimal whitespace while maintaining clarity.
    - NOW IN LANDSCAPE (horizontal) ORIENTATION
    """
    # Use landscape orientation (swaps width and height)
    from reportlab.lib.pagesizes import A4
    PAGE_SIZE = landscape(A4)  # 👈 Landscape orientation
    page_width, page_height = PAGE_SIZE
    
    c = canvas.Canvas(output_pdf, pagesize=PAGE_SIZE)
    margin = 0.4 * INCH
    padding = 0.2 * INCH

    # Add main heading only on first page
    c.setFont("Helvetica-Bold", 20)
    main_title = "DATASET ANALYSIS REPORT"
    title_width = c.stringWidth(main_title, "Helvetica-Bold", 20)
    title_x = (page_width - title_width) / 2
    title_y = page_height - 0.8 * INCH
    
    c.drawString(title_x, title_y, main_title)
    
    # Draw underline
    underline_y = title_y - 5
    c.line(title_x, underline_y, title_x + title_width, underline_y)
    
    # Reset font for captions
    c.setFont("Helvetica", 8)

    # Coordinates and layout control
    x = margin
    y = title_y - 1.2 * INCH  # Start below the title
    max_width = page_width - 2 * margin
    max_img_height = 2.2 * INCH  # small fixed height for compact view

    images_per_page = 4
    img_count = 0

    for img_path, caption in image_list:
        try:
            with Image.open(img_path) as img:
                w, h = img.size
        except Exception:
            w, h = (800, 600)

        # Aspect ratio scaling
        aspect = w / h
        img_width = max_width
        img_height = img_width / aspect

        if img_height > max_img_height:
            img_height = max_img_height
            img_width = img_height * aspect

        # If next image doesn’t fit, start new page
        if y - img_height - 0.8 * INCH < margin:  # Increased gap between images
            c.showPage()
            # Add main heading only on first page (not on subsequent pages)
            if img_count > 0:  # Only add on first page
                c.setFont("Helvetica", 8)
            else:
                c.setFont("Helvetica", 8)
            y = page_height - margin
            img_count = 0

        # Center align the image
        x = (page_width - img_width) / 2

        # Draw image and caption
        c.drawImage(img_path, x, y - img_height, width=img_width, height=img_height, preserveAspectRatio=True)
        y -= img_height + 0.4 * INCH  # Increased gap between image and caption
        c.drawCentredString(page_width / 2, y, caption)
        y -= 0.6 * INCH  # Increased gap between caption and next image
        img_count += 1

        # Force new page after 4 images to keep uniformity
        if img_count == images_per_page:
            c.showPage()
            c.setFont("Helvetica", 8)
            y = page_height - margin
            img_count = 0

    c.save()
    print(f"✅ Compact PDF saved successfully at: {output_pdf}")

# Save PDF in the img folder inside assignment
output_pdf = os.path.join(img_folder, pdf_file_name)
save_images_to_compact_pdf(images, output_pdf)