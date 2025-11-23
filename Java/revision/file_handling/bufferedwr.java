import java.io.*;
import java.util.*;

class bufferedwr{
    public static void main(String []args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bf=new  BufferedWriter(new FileWriter("text.txt"));
        System.out.println("enter the text:");
        String s=sc.nextLine();
        bf.write(s);
        bf.close();

        BufferedReader br=new BufferedReader(new FileReader("text.txt"));
        String l=br.readLine();
        System.out.print("file content:"+l);
        br.close();

    }
}