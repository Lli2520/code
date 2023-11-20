package com.briup.ch07;

import java.lang.String;



abstract public  class Animal {
    static  int count=10;

    static void methodA(){
        System.out.println("少壮不努力老大徒伤悲");
    }
    public String name;
//    抽象方法没有具体实现  只能交给子类重写
//    且因为抽象类中可能有抽象方法  所以抽象类不能实例化
    public abstract void eat();
    public abstract void sleep();

    public void  breath(){
        System.out.println("离不开氧气");
    }

    Animal(){
        System.out.println("这是抽象类的构造器");
    }


}
