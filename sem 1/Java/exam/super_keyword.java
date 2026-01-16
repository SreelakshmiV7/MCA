class parent{
    String name;
}

class child extends parent{
    String name;
    public void showdetails(){
        super.name="Parent class ";
        name="Child class ";
        System.out.println(super.name);
        System.out.println(name);
    }}

public class super_keyword {
    public static void main(String[] args) {
        child c=new child();
        c.showdetails();
    }
}