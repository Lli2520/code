package com.briup.test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName : ServerMain
 * Package : com.briup.test1
 * Description : TDOO
 * 服务主机
 * 1、搭建一台TCP服务器
 * 2、接受客户端的连接，使得服务器与客户端可以成功建立连接
 * 3、接收客户端发送过来的数据，输出在控制台上（使用字节流）
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/6 14:57
 * @Version : v1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //声明TCP服务器
        ServerSocket serverSocket = null;
        //声明套接字
        Socket socket = null;
        //声明缓冲字节输入流
        BufferedInputStream bis = null;
        //声明内存输出流
        ByteArrayOutputStream baos = null;
        //定义端口并赋值
        int port = 9999;
        try {
            //创建TCP服务器
            serverSocket = new ServerSocket(port);
            //提示用户服务器创建成功等待客户端的连接！
            System.out.println("服务器创建成功等待客户端的连接！");
            //等待客户端连接,拿到套接字对象
            socket = serverSocket.accept();
            //提示用户客户端连接成功，打印客户端信息
            System.out.println("客户端" + socket + "连接成功！");
            //创建缓冲字节输入流
            bis = new BufferedInputStream(socket.getInputStream());
            //创建内存输出流
            baos = new ByteArrayOutputStream();

            //创建字节数组
            byte[] data = new byte[1024];
            //定义一个变量记录读取到的长度
            int length;

            //读
            while ((length = bis.read(data)) != -1) {
                //写
                baos.write(data, 0, length);
            }

            //输出读到的内容
            System.out.println(baos.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
