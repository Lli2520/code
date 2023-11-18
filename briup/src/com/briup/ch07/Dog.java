package com.briup.ch07;

/**
 * @Author briup-adam
 * @Date 2023/10/8 上午10:37
 * @Description
 **/

public class Dog  extends  Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    @Override
    public void sleep() {
        System.out.println("趴着睡");
    }


}
