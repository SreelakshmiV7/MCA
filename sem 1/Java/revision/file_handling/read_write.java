import java.io.*;
import java.util.Scanner;

class read_write{
    public static void main(String [] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        FileWriter fw=new FileWriter("text1.txt");
        System.out.println("enter the text:");
        String l=sc.nextLine();
        fw.write(l);
        fw.close();

        FileReader fr=new FileReader("text1.txt");
        int ch;
        while((ch=fr.readLine())!=-1)
        {
            System.out.print((char)ch);
        }
        fr.close();
    }
}