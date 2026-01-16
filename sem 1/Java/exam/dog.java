class animal{
    void eat(){
        System.out.println("eating...");
    }
}

class cat extends animal{
    void eat(){
        System.out.println("eating cat food...");
    }
}

class dog extends animal{
    void eat(){
        System.out.println("eating dog food...");
    }
    void bark(){
        System.out.println("barking...");
    }

public static void main(String args[]){
    dog d=new dog();
    d.eat();
    d.bark();
    cat c=new cat();
    c.eat();
}
}