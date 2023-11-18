package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午8:32
 * @Description
 **/

public class InnerClassDemo3 {
    public static void main(String[] args) {

    }
}
class  Outer3{
//   全局变量
    public int a=0;
    public void  methodA(){
//        局部变量
//        JDK8中，方法中定义的局部变量，如果在局部内部类中对其访问操作，那么这个局部变量会默认加上final修饰，其值不能改变。
        int a=5;
//        局部内部类
        class  Inner3{
//            int  a=12;
            Inner3(){
//                局部内部类中访问外部类的局部变量一定是final修饰的
//                a=10;
                System.out.println(a);
                System.out.println(Outer3.this.a);
            }
        }
    }
}
