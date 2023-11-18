package com.briup.test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * ClassName : ServerMain
 * Package : com.briup.test3
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/7 18:19
 * @Version : v1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //声明ServerSocket
        ServerSocket serverSocket = null;
        try {
            //创建ServerSocket
            serverSocket = new ServerSocket(9999);
            //输出提示：服务器启动成功
            System.out.println("服务器已启动等待客户端的连接！");
            //服务器要一直接收客户端
            while (true) {
                //初始化套接字
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    //客户端连接成功
                    System.out.println("客户端已经成功连接到服务器！客户端IP：" + socket);
                }
                //创建线程并启动
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //声明缓冲字符输入流
                        BufferedReader br = null;
                        //声明缓冲字节输入流
                        BufferedInputStream bis = null;
                        //声明缓冲字节输出流
                        BufferedOutputStream bos = null;
                        try {
                            //初始化缓冲字符输入流
                            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            //读取请求行数据
                            String requestLine = br.readLine();
                            //按照空格分割字符串
                            String[] requestLineData = null;
                            if (!Objects.isNull(requestLine)) {
                                requestLineData = requestLine.split("[ ]");
                            }
                            /**
                             * 拿到请求资源路径创建文件对象
                             */
                            //声明文件对象
                            File file = null;
                            if (requestLineData[1].equals("/")) {
                                //指向首页
                                file = new File("E:\\大三\\resource\\index\\index.html");
                            } else {
                                //指向指定文件
                                file = new File("E:\\大三\\resource" + requestLineData[1]);
                            }
                            //创建字节数组，存放读取到的数据
                            byte[] data = new byte[1024];
                            //定义变量记录每次读取到的数据长度
                            int length;
                            //初始化缓冲字节输出流
                            bos = new BufferedOutputStream(socket.getOutputStream());
                            //判断文件是否存在
                            if (file.exists()) {
                                //文件存在  响应指定文件回去
                                //写请求行
                                bos.write("HTTP/1.1 200 OK \r\n".getBytes());
                                //初始化缓冲字节输入流
                                bis = new BufferedInputStream(new FileInputStream(file));
                            } else {
                                //文件不存在 响应error页面回去
                                //写请求行
                                bos.write("HTTP/1.1 404 NOT FOUND \r\n".getBytes());
                                //初始化缓冲字节输入流
                                bis = new BufferedInputStream(new FileInputStream(new File("E:\\大三\\resource\\error\\error.html")));
                            }
                            //响应头（可省略）
                            //响应空行
                            bos.write("\r\n".getBytes());
                            //读取文件
                            while ((length = bis.read(data)) != -1) {
                                //写回读到的内容
                                bos.write(data, 0, length);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } finally {
                            //关闭资源
                            try {
                                //关闭缓冲输出流
                                if (bos != null) {
                                    bos.close();
                                }
                                //关闭缓冲字节输出流
                                if (bis != null) {
                                    bis.close();
                                }
                                //关闭缓冲输入流
                                if (br != null) {
                                    br.close();
                                }
                                if (socket != null) {
                                    //关闭socket连接
                                    socket.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                //关闭ServerSocket
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
