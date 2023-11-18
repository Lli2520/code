package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/27 上午8:21
 * @Description
 **/

public class ThreadSafeTest {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            private int num = 50;
            String s = "闫昊";

            @Override
            public void run() {
                while (true) {
                    synchronized (s) {
                        if (num <= 0)
                            break;
                        num--;
                        Thread t = Thread.currentThread();
                        String name = t.getName();
                        System.out.println(name + "进行售票，余票：" + num);

                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();

    }
}
