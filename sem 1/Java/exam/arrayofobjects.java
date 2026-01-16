class products{
    int id;
    String name;
    products(int pid,String n){
        id=pid;
        name=n; 
    }
    void display(){
        System.out.println("id: "+id+" name:"+name);
        System.out.println();
    }
}

public class arrayofobjects {
    public static void main(String[] args) {
        products p1=new products(101,"Laptop");
        products p2=new products(102,"Mobile");
        products p3=new products(103,"Tablet");
        products p4=new products(104,"Smartwatch");
        products p5=new products(105,"Desktop");

        products arr[]={p1,p2,p3,p4,p5};
        for(int i=0;i<arr.length;i++){
            arr[i].display();
        }
    }
}