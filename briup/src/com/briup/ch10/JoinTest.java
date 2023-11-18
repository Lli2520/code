package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午11:29
 * @Description
 **/

public class JoinTest {
    public static void main(String[] args) {
        Thread t1=new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <26; i++) {
                    System.out.println(i);
                }
            }
        };
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (char i = 97; i <123 ; i++) {

                    System.out.println(i);
                }
            }
        });
        t1.start();
        t2.start();
        try {
            //当前线程等待t1执行结束
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (char i = 65; i <91 ; i++) {
            System.out.println(i);
        }
    }
}
