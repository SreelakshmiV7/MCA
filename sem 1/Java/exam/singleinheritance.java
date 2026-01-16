class s1{
    int n1=10;
    int n2=20;
}
class singleinheritance extends s1{
    int n3=30;
    public static void main(String[] args) {
        singleinheritance s=new singleinheritance();
        int n4=s.n1+s.n2+s.n3;
        System.out.println("Sum: " + n4);
}}