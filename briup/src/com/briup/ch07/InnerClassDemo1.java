package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/10 下午6:03
 * @Description
 **/

public class InnerClassDemo1 {

    public static void main(String[] args) {
        System.out.println(new Outer1().new Inner1().a);//11
    }
}

class Outer1 {
    //成员变量
    public int a = 10;
    private int b = 111;

    Outer1() {
        System.out.println(a);//10
        System.out.println(new Inner1().a);//11
    }

    //成员内部类
    class Inner1 {
        //内部类的成员变量
        public int a = 11;

        Inner1() {
            System.out.println(b);
            System.out.println(a); //11
            System.out.println(Outer1.this.a);//10
        }
    }
}
