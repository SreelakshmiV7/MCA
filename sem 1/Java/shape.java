class shape1{
    void calculatearea()
    {
        System.out.println("area of shape");
    }
}

class circle extends shape1 {
    double r;
    final double p=3.14;
    circle(double r){
        this.r=r;
    }
    @Override
    void calculatearea()
    {
        double i=p*(r*r);
        System.out.println("area  of circle "+i);
    }

}

public class shape{
    public static void main(String [] args)
    {
        circle s=new circle(10);
        s.calculatearea();
        // s.calculatearea(2.1);

    }
}