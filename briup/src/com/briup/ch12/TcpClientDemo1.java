package com.briup.ch12;

import java.lang.String;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午8:47
 * @Description 搭建tcp客户端
 * @see Socket
 **/

public class TcpClientDemo1 {
    public static void main(String[] args) {
        //声明资源
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            //创建客户端
            socket = new Socket("127.0.0.1", 10086);
            System.out.println("客户端已经创建 连接到服务器");
            //发消息给服务器
            String msg = "与君初相识，犹如故人归。你好！";
            os = socket.getOutputStream();
            os.write(msg.getBytes());
            os.flush();
            socket.shutdownOutput();
            System.out.println("消息发送成功");
            //接收服务器的消息
            is = socket.getInputStream();
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
            System.out.println("消息接收成功");
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (is != null)
                    is.close();

                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
