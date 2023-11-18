package com.briup.ch07;

import java.lang.String;

import java.util.Arrays;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午9:00
 * @Description
 **/

public class InnerClassDemo4 {
    public static void main(String[] args) {
        Outer4 outer4=new Outer4(){
            @Override
            void methodB() {
                System.out.println("闫昊背古诗");
            }
        };
        System.out.println(outer4);
        Outer5 outer5=new Outer5("闫昊"){
            @Override
            public void methodC() {
                System.out.println("闫昊走鸭子步");
            }
        };
        System.out.println(outer5);
        outer5.methodD();
        outer5.methodC();
        ISleep iSleep =()-> System.out.println("哈哈哈哈哈哈哈哈");
        iSleep.sleep();
        Integer integer = Arrays.asList(1, 3, 5, 7).stream().map((i -> i * 10)).reduce((i, j) -> i + j).filter(i -> i % 2 == 0).get();


    }
}
abstract  class Outer4{
    public void  methodA(){
        System.out.println("闫昊");
    }
    abstract  void  methodB();
}
class Outer5{
    public void methodC(){
        System.out.println("杨硕");
    }
    public  void  methodD(){
        System.out.println("朝辞白帝彩云间");
    }
    Outer5(String name){
        System.out.println(name);
    }

}
