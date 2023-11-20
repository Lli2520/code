package com.briup.ch07;

import java.lang.String;



public class ActionImpl  implements IAction{

    public void show(){
        System.out.println("黄河之水天上来");
    }
    @Override
    public void start() {
        System.out.println("实现类重写接口的抽象方法");
    }
}
 class ActionImplTest{
     public static void main(String[] args) {
         ActionImpl action = new ActionImpl();
         action.start();
//实现类可以继承接口的默认方法  也可以重写
         action.methodB();
         //接口中的静态方法只能通过接口名调用
//         action.methodA();
//         ActionImpl.methodA();
//         接口中的静态常量可以正常继承
         System.out.println(action.NUM);
//         接口的多态
        IAction a= new ActionImpl();
//        a.show();
         a.start();




     }
 }
