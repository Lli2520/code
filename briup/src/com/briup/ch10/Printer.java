package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/27 上午8:57
 * @Description
 **/

public class Printer {
    public synchronized void print1() {
        System.out.print("好");
        System.out.print("好");
        System.out.print("学");
        System.out.println("习");
    }

    public void print2() {
        synchronized (this) {
            System.out.print("天");
            System.out.print("天");
            System.out.print("向");
            System.out.println("上");
        }
    }

    public static synchronized void print3() {
        System.out.print("吃");
        System.out.print("喝");
        System.out.print("玩");
        System.out.println("乐");
    }

    public static void print4() {
        synchronized (Printer.class) {
            System.out.print("勤");
            System.out.print("学");
            System.out.print("好");
            System.out.println("问");
        }
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    p.print1();
                }

            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {
                    p.print2();
                }
            }
        };
//        t1.start();
//        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <50 ; i++) {
                    Printer.print3();
                }

            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <50 ; i++) {
                    Printer.print4();
                }
            }
        };
        t3.start();
        t4.start();

    }
}
