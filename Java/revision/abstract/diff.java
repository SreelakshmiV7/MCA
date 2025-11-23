// Abstract class
abstract class Shape {

    // abstract method (no body)
    abstract void draw();

    // non-abstract method
    void info() {
        System.out.println("This is a shape.");
    }

    // static variable
    static String type = "2D";

    // non-final variable
    final int sides = 0;
}

// Subclass that provides implementation
class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class diff {
    public static void main(String[] args) {

        Shape s = new Circle();  // Upcasting
        s.draw();                // calls child's implementation
        s.info();                // inherited method from abstract class

        System.out.println("Type: " + Shape.type);
        System.out.println("Sides: " + s.sides);

    }
}
