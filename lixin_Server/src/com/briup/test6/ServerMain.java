package com.briup.test6;

import com.briup.test6.system.Constant;
import com.briup.test6.task.RunnableTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName : ServerMain
 * Package : com.briup.test6
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 8:01
 * @Version : v1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //启动服务器
        load();
    }

    /**
     * 加载服务器
     */
    public static void load() {
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(Constant.THREAD_COUNT);
        //声明TCP服务器
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Constant.PORT);
            System.out.println("服务器启动成功，等待客户端连接");
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable runnable = new RunnableTask(socket);
                service.submit(runnable);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
