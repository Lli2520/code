package com.briup.ch12;

import java.lang.String;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午10:00
 * @Description 服务器不宕机  客户端上传图片
 * 服务器根据用户ip进行图片保存  保存成功之后做出反馈
 *
 *
 **/

public class TcpServerDemo2 {
    public static void main(String[] args) {
        try {
            //服务器创建
            ServerSocket server = new ServerSocket(10086);
            System.out.println("服务器已经创建 等待客户端连接");
            // 保证服务器不关机
            while (true){
                //等待客户端连接
                Socket socket = server.accept();
                //获取客户端ip
                String address = socket.getInetAddress().toString();
                System.out.println("客户端："+address+"来连接");
                //接收图片数据
                FileOutputStream fos=new FileOutputStream("01code/src/com/briup/ch12/"+address+".png");
                InputStream is = socket.getInputStream();
                int len=0;
                byte b[] =new  byte[1024];
                while((len=is.read(b))!=-1){
                    //将图片数据保存到文件
                    fos.write(b,0,len);
                }
                fos.flush();
                //关闭读取的输入流
                socket.shutdownInput();
                //服务器给客户端一个反馈
                String msg = address + ":你上传的文件已经收到！👌🏻";
                OutputStream os = socket.getOutputStream();
                os.write(msg.getBytes());
                socket.shutdownOutput();
                fos.close();
                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
