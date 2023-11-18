package com.lixin.Test1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:ServerMain
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/6/006 14:57
 * @Version 1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            System.out.println("等待客户端连接....");
            Socket socket = server.accept();
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println(socket + " 客户端连接成功");
            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            // 读取客户端发送的数据
            byte[] buffer = new byte[8192];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                String receive = new String(buffer, 0, length);
                System.out.println("收到客户端发送的数据：" + receive);
            }
            // 关闭资源
            inputStream.close();
//            socket.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
