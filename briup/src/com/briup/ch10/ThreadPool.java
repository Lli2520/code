package com.briup.ch10;

import java.lang.String;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午3:00
 * @Description 线程池
 **/

public class ThreadPool {
    public static void main(String[] args) {
        //构建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //构建任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };
        //提交任务
        for (int i = 0; i <20 ; i++) {

            pool.submit(task);
        }
    }
}
