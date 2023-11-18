package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/10 下午5:38
 * @Description
 **/

public abstract class Animal2 {
    private String color;
    private int age;

    public Animal2() {

    }

    public Animal2(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public abstract void eat();

    public abstract void sleep();
}
