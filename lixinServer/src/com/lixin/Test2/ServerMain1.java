package com.lixin.Test2;

import java.io.*;
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
        //声明套接字对象
        Socket socket = null;
        //声明缓冲字节输入流
        BufferedReader br = null;
        //声明缓冲字节输入流
        BufferedInputStream bis = null;
        //声明缓冲字节输出流
        BufferedOutputStream bos = null;
        try {
            //搭建一台TCP服务器
            serverSocket = new ServerSocket(9999);
            //提示信息
            System.out.println("服务器启动成功，等待客户端连接！");

            //接受客户端连接 初始化套接字
            socket = serverSocket.accept();
            //提示信息
            System.out.println("客户端" + socket + "连接成功！");

            //初始化缓冲字符输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //读取请求行
            String requestLine = br.readLine();
            //请求行输出在控制台
            System.out.println(requestLine);

            //定义字符串 记录读取到的数据
            String requestData;
            //读
            while ((requestData = br.readLine()) != null) {
                if (requestData.equals("")) {
                    System.out.println();
                    break;
                }
                //输出在控制台
                System.out.println(requestData);
            }

            //解析在控制台
            String[] requestLineData = requestLine.split("[ ]");
            //打印请求行信息
            System.out.println("请求方式：" + requestLineData[0]);
            System.out.println("请求资源路径：" + requestLineData[1]);
            System.out.println("协议版本：" + requestLineData[2]); /*
             * 1. /:访问首页-----> index.html
             * 2. /资源名   ------> 对应资源
             */

            //创建文件对象
            File file = ("/").equals(requestLineData[1]) ?
                    new File("E:/resource/index.html") :
                    new File("E:/resource" + requestLineData[1]);

            //初始化缓冲字节输出流（包装套接字里面的字节输出流）
            bos = new BufferedOutputStream(socket.getOutputStream());

            //判断文件是否存在
            if (file.exists()) {
                //文件存在，初始化缓冲字节输入流（正常资源）
                bis = new BufferedInputStream(new FileInputStream(file));
                //响应状态行 HTTP/1.1 200 OK
                bos.write("HTTP/1.1 200 OK \r\n".getBytes());
            } else {
                //文件不存在，初始化缓冲字节输入流（error）
                bis = new BufferedInputStream(new FileInputStream(new File("E:/resource/error.html")));
                //响应状态行 HTTP/1.1 404 NOT FOUND
                bos.write("HTTP/1.1 404 NOT FOUND \r\n".getBytes());
            }

            //响应报头（不用返回）

            //响应空行
            bos.write("\r\n".getBytes());
            //响应体
            //定义字节数组，存储读取到的内容
            byte[] data = new byte[1024];
            //定义变量记录读取到的长度
            int length;
            //读取文件内容
            while ((length = bis.read(data)) != -1) {
                //写给客户端响应
                bos.write(data, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            if (bos != null) {
                try {
                    bos.close();
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
            if (br != null) {
                try {
                    br.close();
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