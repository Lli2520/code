package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午10:28
 * @Description
 **/

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class RunnableTest {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("云想衣裳花想容");
            }
        };
        Thread t = new Thread(r, "古诗");
        t.start();

        r = () -> System.out.println("云想衣裳花想容");
        t = new Thread(r);
        t.start();
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);
        Thread t7 = new Thread(runnable);
        Thread t8 = new Thread(runnable);
        Thread t9 = new Thread(runnable);
        Thread t10 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
