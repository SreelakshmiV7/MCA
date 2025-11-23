class Parent {
    void parentMethod() {
        System.out.println("Parent class method");
    }
}

interface Worker {
    void work();
}

class Child extends Parent implements Worker {
    public void work() {
        System.out.println("Child works");
    }
}

class Test6 {
    public static void main(String[] args) {
        Child c = new Child();
        c.parentMethod();
        c.work();
    }
}
