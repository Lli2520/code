package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午8:51
 * @Description
 **/

public interface ISleep {
    void  sleep();
}
class SleepImpl  implements  ISleep{
    @Override
    public void sleep() {
        System.out.println("黑发不知勤学早");
    }
}
class SleepTest{
    public static void main(String[] args) {
        ISleep sleep1=new SleepImpl();
        ISleep sleep2=new ISleep(){
//            匿名内部类可以定义属性和方法
            public int a=10;
            public void methodA(){
                System.out.println("闻鸡起舞");
            }
            @Override
            public void sleep() {
                System.out.println("a = " + a);
                System.out.println("劝君惜取少年时");
                methodA();
            }
        };
        sleep1.sleep();
        sleep2.sleep();


    }
}
