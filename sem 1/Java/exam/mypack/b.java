package mypack;

public class B {
    public static void main(String[] args) {
        A obj = new A();
        obj.display();  // ✅ Allowed because both are in the same package
    }
}
