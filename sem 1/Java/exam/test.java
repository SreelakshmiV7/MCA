class cricketer{
    String name;
    String team;
    int age;

    cricketer(){
        name="";
        team="";
        age=0;
    }
    cricketer(String n, String t, int a){
        name=n;
        team=t;
        age=a;
    }
}

class test{
    public static void main(String [] args){
        cricketer c1=new cricketer();
        cricketer c2=new cricketer("Virat Kohli", "India", 32); 
        c1.name="MS Dhoni";
        c1.team="India";
        c1.age=39;  
        System.out.println(c1.name+" "+c1.team+" "+c1.age);
        System.out.println(c2.name+" "+c2.team+" "+c2.age); 
}
}