class employee{
    private int id;
    private String name;
    private int age;
    public int getId() {
        return id;
    }   
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

public class privateexample {
    public static void main(String[] args) {
        employee e=new employee();
        e.setId(101);
        e.setName("john");
        e.setAge(25);
        //System.out.println(e.id);// compilation error as id is private
        //System.out.println(e.name);// compilation error as name is private
        //System.out.println(e.age);// compilation error as age is private
        System.out.println("employee id: "+e.getId());
        System.out.println("employee name: "+e.getName());
        System.out.println("employee age: "+e.getAge());
    }
}