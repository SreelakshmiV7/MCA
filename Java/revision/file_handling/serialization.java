
import java.io.*;

class serialization{
    public static void main(String []args)
    {
        try {
            stud s=new stud(111,"sree");
            FileOutputStream fout=new FileOutputStream("text.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s);
            out.flush();
            out.close();
            System.out.println("done....");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}