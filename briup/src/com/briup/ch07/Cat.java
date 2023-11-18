package com.briup.ch07;

/**
 * @Author briup-adam
 * @Date 2023/10/8 上午10:36
 * @Description
 **/

public class Cat  extends  Animal{

    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override//这个注解是判断该方法是否发生重写
    public void sleep() {
        System.out.println("躺着睡");

    }

    public Cat(){
        super();
    }
}
