package com.company.General;

class animal{

    public void sound(){
        System.out.println("blah blah");
    }
}

class dog extends animal{
    @Override
    public void sound() {
        System.out.println("bow");
    }

    public void sound1() {
        System.out.println("bow");
    }
}

public class Test {

    public static void main(String[] args){
        animal a = new animal();
        dog d = new dog();
        a = (dog) d;
    }
}
