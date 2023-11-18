package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午10:10
 * @Description
 **/

public class ThreadTest1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("小白兔") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("小白兔白又白两只耳朵竖起来");
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.setName("闫昊");
        //启动线程
        t1.start();
        System.out.println(t1.getName());
//        t1.run();
    }
}
