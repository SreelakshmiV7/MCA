interface X {
    void x();
}

interface Y {
    void y();
}

interface Z extends X, Y {
    void z();
}

class Implementer implements Z {

    public void x() { System.out.println("X method"); }
    public void y() { System.out.println("Y method"); }
    public void z() { System.out.println("Z method"); }
}

class Test5 {
    public static void main(String[] args) {
        Z obj = new Implementer();
        obj.x();
        obj.y();
        obj.z();
    }
}
