import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter file name to create:");
            String fileName = sc.nextLine();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String content = sc.nextLine();
            writer.write(content);
            writer.close();
            
            System.out.println("File '" + fileName + "' created successfully.");
        }
        catch(Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}