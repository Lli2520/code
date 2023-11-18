package com.lixin.Test5;

import com.lixin.Test5.System.Constant;
import com.lixin.Test5.task.RunnableTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ServerMain
 * Description:服务主机
 *
 * @Authonr 李欣
 * @Create 2023/11/9/009 15:17
 * @Version 1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(Constant.THREAD_COUNT);
        //声明TCP服务器
        ServerSocket serverSocket = null;
        try {
            //创建TCP服务器
            serverSocket = new ServerSocket(Constant.PORT);
            //循环接收客户端的请求
            while (true) {
                //接受请求
                Socket socket = serverSocket.accept();
                //创建自定义任务
                Runnable runnable = new RunnableTask(socket);
                //从线程池获取线程执行自定义任务
                service.submit(runnable);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            if (service != null) {
                service.shutdown();
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}