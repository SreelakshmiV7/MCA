abstract class Bike {
    Bike() {
        System.out.println("bike is created");
    }

    abstract void run();

    void changeGear() {
        System.out.println("gear changed");
    }
}

class Honda extends Bike {
    @Override
    void run() {
        System.out.println("running safely..");
    }
}

class test1 {
    public static void main(String args[]) {

        Bike obj = new Honda();  // Upcasting (abstract reference → child object)

        //obj.run();         // calls Honda's implementation
        //obj.changeGear();  // inherited concrete method
    }
}
