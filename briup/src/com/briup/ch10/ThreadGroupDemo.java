package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午11:01
 * @Description
 **/

public class ThreadGroupDemo {
    public static void main(String[] args) {
        //获取当前线程对象
        Thread thread = Thread.currentThread();
        //获取该线程的线程组
        ThreadGroup group = thread.getThreadGroup();
        System.out.println(group);

        //创建子线程
        Thread t1 = new Thread();
        ThreadGroup group1 = t1.getThreadGroup();
        System.out.println(group1);

        //创建线程组
        ThreadGroup group2 = new ThreadGroup("风雨五组");
        Thread t2 = new Thread(group2, "李想");
        System.out.println(t2);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3 = new Thread(group2, r, "高博");
        Thread t4 = new Thread(group2, r, "李欣");
        Thread t5 = new Thread(group2, r, "钱慧敏");
        Thread t6 = new Thread(group2, r, "郭雅鑫");

        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取线程组中活跃的线程数
        int count = group2.activeCount();
//        获取当前线程所在组中活跃线程数
//        t2.activeCount();
        Thread[] threads = new Thread[count];
        int i = group2.enumerate(threads);
        for (Thread thread1 : threads) {
            System.out.println("arr-"+thread1);
        }
    }
}
