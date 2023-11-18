package com.lixin.Test1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:ServerMain1
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/7/007 17:26
 * @Version 1.0
 */
public class ServerMain1 {
    public static void main(String[] args) {
        //声明TCP服务器
        ServerSocket serverSocket = null;
        //声明套接字
        Socket socket = null;
        //声明缓冲字节输入流
        BufferedInputStream bis = null;
        //声明内存输出流
        ByteArrayOutputStream baos = null;

        try {
            //创建TCP服务器
            serverSocket = new ServerSocket(9999);
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
