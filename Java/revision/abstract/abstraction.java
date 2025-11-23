abstract class A {
    abstract void m1();     // abstract method
    void m2() {             // normal method
        System.out.println("Method m2 from A");
    }
}

abstract class B extends A {
    // did not implement m1() → so B must be abstract
    void m3() {
        System.out.println("Method m3 from B");
    }
}

class C extends B {
    void m1() {
        System.out.println("m1 implemented in C");
    }
}

class abstraction {
    public static void main(String[] args) {
        // A a = new A();   // ❌ ERROR: cannot instantiate abstract class

        A obj = new C();     // Abstract class reference to subclass object
        obj.m1();            // Runs C's implementation
        obj.m2();            // Inherited from A

        C c = new C();
        c.m3();              // from B
    }
}
