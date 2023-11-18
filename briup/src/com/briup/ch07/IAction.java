package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/10 下午4:54
 * @Description 定义接口关键字  interface
 **/

public interface IAction {
    //接口中的变量 默认都是公共的静态常量  可以通过接口名直接访问
//    常量命名都是纯大写
    //public  static  void  int  NUM=10;
    int NUM = 10;

    //    jdk1.8 之前接口中所有的方法都是抽象方法
    //    1.8新增 静态方法和默认方法 具体实现的方法
    // public abstract void start();
    void start();

    // 1.8新增 静态方法  可以通过接口名直接调用
    static void methodA() {
        System.out.println(" 1.8新增 静态方法");
    }

    // 1.8新增 默认方法
    default void methodB() {
        System.out.println("1.8新增 默认方法");
    }

    public static void main(String[] args) {
        //接口不能实例化
//        接口没有构造器
//        IAction action = new IAction();
        System.out.println(IAction.NUM);
        IAction.methodA();
    }
}
