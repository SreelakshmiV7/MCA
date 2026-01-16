class Emp{
    int empno;
    String empname;

    Emp(){
        System.out.println("Constructor Executed.");
        
    }
    void display(){
        System.out.println("Welcome..");
    }
}

public class Constructor01{
    public static void main(String [] args){
        Emp e1 = new Emp();
        e1.display();
    }
}