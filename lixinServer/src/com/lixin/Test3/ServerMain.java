package com.lixin.Test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * ClassName:ServerMain
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/8/008 14:35
 * @Version 1.0
 */
class NumberThread1 implements Runnable {
    private Socket socket;

    public NumberThread1(Socket socket) {
        this.socket = socket;
    }

    @Override
//    public void run() {
//        //声明TCP服务器
//        ServerSocket serverSocket = null;
//        try {
//            //创建TCP服务器
//            serverSocket = new ServerSocket(10086);
//            //提示信息
//            System.out.println("服务器启动成功，等待客户端连接！");
//            //死循环，要一直接收客户端的请求
//            while (true) {
//                //堵塞状态，等待客户端连接，拿到Socket对象
//                Socket socket = serverSocket.accept();
//                //提示信息
//                System.out.println("客户端" + socket + "连接成功");
//                //创建线程对象（匿名内部类方式创建任务）
//                new Thread(new Runnable() {
//                    @Override
    public void run() {
        BufferedReader br = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //初始化缓冲字符输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取请求行数据
            String requestLine = br.readLine();
            //按照空格分割请求行（字符串）
            String[] requestData = requestLine.split("[ ]");
            //根据资源路径创建文件
            File file = "/".equals(requestData[1]) ?
                    new File("E:/resource/index.html") :
                    new File("E:/resource" + requestData[1]);

            //初始化缓冲字节输出流
            bos = new BufferedOutputStream(socket.getOutputStream());
            //判断文件对象是否存在
            if (file.exists()) {
                //初始化缓冲字节输入流（具体文件）
                bis = new BufferedInputStream(new FileInputStream(file));
                //响应状态行
                bos.write("HTTP/1.1 200 OK \r\n".getBytes());
            } else {
                //初始化缓冲字节输入流
                bis = new BufferedInputStream(new FileInputStream(new File("E:/resource/error.html")));
                //相应状态行
                bos.write("HTTP/1.1 404 NOT FOUND \r\n".getBytes());
            }
            //相应空行
            bos.write("\r\n".getBytes());

            //创建字节数组 存储读到的内容
            byte[] data = new byte[1024];
            //记录读取的长度
            int length;
            //读文件
            while ((length = bis.read(data)) != -1) {
                //响应体 写回客户端
                bos.write(data, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (br != null) {
                    br.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭服务器
//            if (serverSocket != null) {
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }


public class ServerMain {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket;
        try {
            //创建TCP服务器
            serverSocket = new ServerSocket(10086);
            //提示信息
            System.out.println("服务器启动成功，等待客户端连接！");
            //死循环，要一直接收客户端的请求
            while (true) {
                //堵塞状态，等待客户端连接，拿到Socket对象
                socket = serverSocket.accept();
                //提示信息
                System.out.println("客户端" + socket + "连接成功");
                //创建线程对象（匿名内部类方式创建任务）
                ExecutorService service = Executors.newFixedThreadPool(2);
                service.submit(new NumberThread1(socket));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
