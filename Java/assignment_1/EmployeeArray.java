import java.util.*;

class Employee {
    int empId;
    String name;
    double salary;

    // Method to set employee details
    void setDetails(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("EmpID: " + empId + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Employee[] employees = new Employee[n];

        // Input details
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();  // create object for each employee
            System.out.println("\nEnter details for Employee " + (i + 1));
            
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            employees[i].setDetails(id, name, salary);
        }

        // Display all employees
        System.out.println("\n--- Employee Details ---");
        for (int i = 0; i < n; i++) {
            employees[i].displayDetails();
        }
    }
}
