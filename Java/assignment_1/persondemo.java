import java.util.*;

class Person {
    String name;
    int age;

    // Method to set details
    void setDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class persondemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person p1 = new Person();
        Person p2 = new Person();

        // Person 1
        System.out.print("Enter name of Person 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter age of Person 1: ");
        int age1 = sc.nextInt();
        sc.nextLine(); // clear buffer
        p1.setDetails(name1, age1);

        // Person 2
        System.out.print("Enter name of Person 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter age of Person 2: ");
        int age2 = sc.nextInt();
        p2.setDetails(name2, age2);

        // Display details
        System.out.println("\n--- Person Details ---");
        p1.displayDetails();
        p2.displayDetails();
    }
}
