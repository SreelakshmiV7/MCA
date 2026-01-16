
class Person {
    private String name; 

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Employee extends Person {
    private int id;

    public Employee(int id, String name) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

public class Employee1 {
    public static void main(String[] args) {
      
        Employee emp = new Employee(101, "Sreelakshmi");

        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee ID: " + emp.getId());
    }
}


