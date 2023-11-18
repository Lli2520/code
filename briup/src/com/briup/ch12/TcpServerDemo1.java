package com.briup.ch12;

import java.lang.String;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午8:47
 * @Description 搭建tcp服务器
 * @see ServerSocket
 **/

public class TcpServerDemo1 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;


        try {
            //创建服务器对象
            server = new ServerSocket(10086);
            System.out.println("服务器开启 监听端口10086  等待客户端连接……");
            //等待客户端连接  会造成线程阻塞
            socket = server.accept();
            System.out.println("有客户端来连接：" + socket.getInetAddress());
            //接收客户端的消息
            is = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
            System.out.println("接收客户端的消息");
            socket.shutdownInput();
            //发送消息给客户端
            os = socket.getOutputStream();
            String msg = "海内存知己，天涯若比邻。再见!";
            os.write(msg.getBytes());
            os.flush();
            socket.shutdownOutput();
            System.out.println("发送消息给客户端");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
                if (server != null)
                    server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
