package com.briup.test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName : ServerMain
 * Package : com.briup.test4
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/8 15:41
 * @Version : v1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //声明ServerSocket
        ServerSocket serverSocket = null;
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            //创建ServerSocket对象
            serverSocket = new ServerSocket(9999);
            //输出提示：服务器启动成功
            System.out.println("服务器已启动等待客户端的连接！");
            //循环接收客户端请求
            while (true) {
                //拿到套接字对象
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    //客户端连接成功
                    System.out.println("客户端已经成功连接到服务器！客户端IP：" + socket);
                }
                //创建任务
                Runnable runnable = new Runnable() {
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
                                throw new RuntimeException(e);
                            }
                        }
                    }
                };
                //从线程池调用线程完成指定任务
                service.submit(runnable);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
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
