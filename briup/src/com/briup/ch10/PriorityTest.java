package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午10:54
 * @Description
 **/

public class PriorityTest {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(i);
                }
            }
        };
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char i = 97; i < 10097; i++) {
                    System.out.println(i);
                }
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        t1.start();
    }
}
