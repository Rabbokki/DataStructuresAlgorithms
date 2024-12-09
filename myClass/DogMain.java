package myClass;

import myClass.createClass.Dog;

public class DogMain {
    public static void main(String[] args) {
        Dog toto = new Dog();
        System.out.println(toto.type);
        System.out.println(toto.name);
        System.out.println(toto.age);
        System.out.println(toto.color);

        //1년후
        toto.age++;
        toto.color = "노란색";

        System.out.println("=====1년후");
        System.out.println(toto.color);
        System.out.println(toto.age);
    }
}
