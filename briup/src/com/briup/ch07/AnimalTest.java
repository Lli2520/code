package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/8 上午10:49
 * @Description
 **/

public class AnimalTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.eat();
        dog.eat();
        cat.sleep();
        dog.sleep();
        System.out.println(cat.name);
        System.out.println(dog.name);
        cat.breath();
        dog.breath();
        Animal.methodA();
        System.out.println(Animal.count);

        Animal a1=new Cat();
        Animal a2=new Dog();
        a1.eat();
        a2.eat();
    }
}
