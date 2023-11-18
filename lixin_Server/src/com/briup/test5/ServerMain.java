package com.briup.test5;

import com.briup.test5.system.Constant;
import com.briup.test5.task.RunnableTask;
import com.briup.test5.util.LoadArgs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName : ServerMain
 * Package : com.briup.test5
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/9 15:30
 * @Version : v1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //声明TCP服务器
        ServerSocket serverSocket = null;
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(Integer.parseInt(LoadArgs.getValue("thread_count")));
        try {
            //初始化TCP服务器
            serverSocket = new ServerSocket(Constant.PORT);
            //提示信息
            System.out.println("服务器启动成功，等待客户端连接！");
            //循环接收客户端的请求
            while (true) {
                //等待客户端连接
                Socket socket = serverSocket.accept();
                //提示信息
                System.out.println("客户端" + socket + "连接成功！");
                //分配任务
                Runnable runnable = new RunnableTask(socket);
                //提交任务
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