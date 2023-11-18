package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午8:39
 * @Description
 **/

public class ThreadSub extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(1);
        }
    }

    public ThreadSub(String name) {
        super(name);
    }

    public static void main(String[] args) {
        ThreadSub sub = new ThreadSub("果渣");
        //普通的方法调用  main线程去执行该方法内部的代码
//        sub.run();
//        开启新的线程 新线程自己去执行自己的代码
        sub.start();
        while (true) {
            System.out.println(2);
//           System.exit(-1);
        }
    }
}
