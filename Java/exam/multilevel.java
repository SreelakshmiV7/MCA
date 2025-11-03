class workerdetails{
    int code;
    String name;
    double salary;
    double hra;
    void setsalary(int c, String n, double s){
        code=c;
        name=n;
        salary=s;
    }
    void showdetails(){
        System.out.println("Worker code: "+code);
        System.out.println("Worker name: "+name);
        System.out.println("Worker salary: "+salary);
    }
    void gethra(){
        hra=salary*0.2;
        System.out.println("HRA: "+hra);
    }
}

class officersal extends workerdetails{
    double da;
    void getda(){
        da=salary*0.5;
        System.out.println("DA: "+da);
    }
}

public class multilevel extends officersal{
    double ca,gross;
    void getca(){
        ca=salary*0.1;
        System.out.println("CA: "+ca);
    }
    void getgross(){
        gross=salary+hra+da+ca;
        System.out.println("Gross salary: "+gross);
    }
    public static void main(String[] args) {
        multilevel m=new multilevel();
        m.setsalary(101, "John", 50000);
        m.showdetails();
        m.gethra();
        m.getda();
        m.getca();
        m.getgross();
    }
}
