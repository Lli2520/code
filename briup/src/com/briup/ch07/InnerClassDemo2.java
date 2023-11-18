package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午8:04
 * @Description
 **/

public class InnerClassDemo2 {
    public static void main(String[] args) {
        System.out.println(new Outer2.Inner2().c);//2
        System.out.println(Outer2.Inner2.a);//5
    }

}


class Outer2 {
    public int a = 10;
    public static int b = 20;

    //    静态成员内部类  可以写静态属性和方法
    static class Inner2 {
        static int a = 5;
        int c = 2;

        Inner2() {
            System.out.println(a);//5
            System.out.println(this.a);//5
//            静态成员内部类访问外部类非静态需要创建对象
            System.out.println(new Outer2().a);//10
            System.out.println(b);//20
        }
    }

    Outer2() {
        System.out.println(Inner2.a);//5

    }
}
