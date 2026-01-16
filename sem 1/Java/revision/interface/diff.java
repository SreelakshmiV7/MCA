// Interface
interface Drawable {

    // abstract method
    void draw();

    // static method (allowed since Java 8)
    static void message() {
        System.out.println("Drawing Shapes!");
    }

    // default method (allowed since Java 8)
    default void color() {
        System.out.println("Default color is Black");
    }
}

// Class implementing interface
class Rectangle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class diff {
    public static void main(String[] args) {

        Drawable d = new Rectangle();

        d.draw();       // abstract method implemented in class
        d.color();      // default method of interface

        Drawable.message();  // calling static method
    }
}
