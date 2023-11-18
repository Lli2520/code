package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/10 下午5:40
 * @Description  一个普通类只能继承一个父类 但是可以实现多个接口
 **/

public class Monkey extends  Animal2 implements IJumpAble,IRideAble {
    private String name;

    public Monkey() {
    }

    public Monkey(String color, int age, String name) {
        super(color, age);
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("猴子偷桃");
    }

    @Override
    public void sleep() {
        System.out.println("倒挂金钩");
    }

    @Override
    public void jump() {
        System.out.println("钻火圈");
    }

    @Override
    public void ride() {
        System.out.println("骑自行车");
    }
}

class  MonkeyTest{
    public static void main(String[] args) {
        Animal2 a = new Monkey("yellow", 2, "小悟空");
        a.eat();
        a.sleep();
        System.out.println("--------------------------------");
        IJumpAble jump=new Monkey("黄的",2,"吉吉国王");
        jump.jump();
        IRideAble ride=new Monkey("黄的",2,"吉吉国王");
        ride.ride();
        System.out.println(ride.VERSION);


    }
}
