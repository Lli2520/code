package com.lixin.Test4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName:Test
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/9/009 15:16
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "zhangsan";
            }
        });

        new Thread(futureTask).start();

        System.out.println(futureTask.get());
        ;
    }
}