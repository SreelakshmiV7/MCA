/*
Java Program using Constructors & Methods.
===========================================
Create a class Student with the instance variables name, rollNumber, and course to store data for each Student object. 
The class should have a parameterized constructor to initialize the instance variables with values passed during object creation. 
The class should also have a default constructor to create a Student object without providing initial values and setting default values for the instance variables. 
Define a method displayStudentDetails() which prints the details of a Student object to the console. 
The class should also contain an updateCourse(String course) method which modifies the course instance variable of a Student object. 
Write down a java program to perform the above operations using the Student object. 
The values for the parameterized constructor should accept from the user.
*/

class Student{
    String stud_name;
    int stud_rollNumber;
    String stud_course;

    Student(){
        this.stud_name = "Sreelakshmi V";
        this.stud_rollNumber = 158;
        this.stud_course = "MCA AIDS";
    }

    Student(String name, int roll, String course){
        this.stud_name = name;
        this.stud_rollNumber = roll;
        this.stud_course  = course;
    }
    void displayStudentDetails(){
        System.out.println("Name: " + stud_name);
        System.out.println("Roll Number: " + stud_rollNumber);
        System.out.println("Course: " + stud_course);
    }
    void updateCourse(String new_course){
        this.stud_course = new_course;
    }
}

public class Assignment{
    public static void main(String args[]){

        Student s1 = new Student();
        s1.displayStudentDetails();

        Student s2 = new Student("Sabhyam",151,"MCA AIDS");
        s2.displayStudentDetails();

        s1.updateCourse("Artificial Intelligence and Data Science, MCA");
        s1.displayStudentDetails();

    }
}