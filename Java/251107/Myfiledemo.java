//create a class students with the fields studno, studname. Define a parameterized constructor to initialize the fields.
import java.io.*;

class students implements Serializable {
    int studno;
    String studname;
    students(int studno, String studname){
        this.studno = studno;
        this.studname = studname;
    }
}

class Myfiledemo{
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {
        students s1 = new students(101, "Alice");
        students s2 = new students(102, "Bob");
        //SERIALIZATION - converting object into byte stream
        //DESERIALIZATION - converting byte stream back to object
        FileOutputStream fos = new FileOutputStream("students");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(s1); //serialization
        out.flush();
        out.close();

        FileInputStream fis = new FileInputStream("students");
        ObjectInputStream in = new ObjectInputStream(fis);
        students s = (students) in.readObject(); 
        students ss = (students) in.readObject();   //deserialization
        System.out.println("Student number: " + s.studno);
        System.out.println("Student name: " + ss.studname);

    }
}