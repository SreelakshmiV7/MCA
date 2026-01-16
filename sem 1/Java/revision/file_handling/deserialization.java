import java.io.*;

class deserialization {
    public static void main(String []args)
    {
       try
       { 
        FileInputStream fint=new FileInputStream("text.txt");
        ObjectInputStream in=new ObjectInputStream(fint);
        stud s=(stud)in.readObject();
        System.out.println(s.n+""+s.name);
        in.close();
       }
       catch (Exception e)
       {
        System.out.println(e);
       }
    }
}