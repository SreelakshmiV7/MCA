class animal{
    @override
    void makesound(){
        System.out.println("Sound");
    }
}

class dog extends animal{
    @override
    void makesound(){
        System.out.println("bark");
    }
}


class cat extends animal{
    @override
    void makesound(){
        System.out.println("meow");
    }
}

class overriding{
    public static void main(String [] args){
        animal  a;
        a= new animal();
        a.makesound();
        a= new dog();
        a.makesound();
        a= new cat();
        a.makesound();
    }

}