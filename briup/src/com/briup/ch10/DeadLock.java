package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午2:41
 * @Description  死锁案例
 **/

public class DeadLock {

    public static void main(String[] args) {
        //万能锁  Object.class
        Object o1=new Object();
        Object o2=new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (o1) {
                        synchronized (o2) {

                        }
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (o2) {
                        synchronized (o1) {

                        }
                    }

                }
            }
        };
        t1.start();
        t2.start();
    }
}
