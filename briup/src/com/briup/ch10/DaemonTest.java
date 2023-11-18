package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/26 上午10:44
 * @Description
 **/

public class DaemonTest {
    public static void main(String[] args) {
//        创建子线程1:Thread子类 + 匿名内部类
//        从1循环输出到30，每次输出后停顿100ms
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 31; i++) {
                    System.out.println(i);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //创建子线程2: Runnable实现类 + 匿名内部类
        // 从100循环输出到50，每次输出后停顿200ms
       Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 100; i >49 ; i--) {
                    System.out.println(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
       t1.start();

       t2.setDaemon(true);
       t2.start();
    }
}
