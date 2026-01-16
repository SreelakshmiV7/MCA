class Emp{
    int empno;
    String empname;

    Emp(){
        System.out.println("Constructor Executed.");
    }

    Emp(int no, String Name){
        this.empno = no;
        this.empname = Name;
        
    }
    void display(){
        System.out.println("Welcome.. "+empname);
    }
}

public class ParameterizedConstructor{
    public static void main(String [] args){
        Emp e1 = new Emp(001,"Sreelakshmi");
        e1.display();
    }
}