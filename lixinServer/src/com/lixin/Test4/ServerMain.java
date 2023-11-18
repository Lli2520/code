package com.lixin.Test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ServerMain
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/9/009 15:15
 * @Version 1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        //搭建TCP服务器
        ServerSocket serverSocket = null;
        //创建线程池对象(10个线程)
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            //创建服务器
            serverSocket = new ServerSocket(9999);
            System.out.println("服务器已开启 等待客户端连接");
            //循环接受客户端的请求
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端已连接" + socket);
                //抽象行为
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader br = null;
                        BufferedInputStream bis = null;
                        BufferedOutputStream bos = null;
                        try {
                            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String requestLine = br.readLine();
                            String[] requestLineData = requestLine.split("[ ]");
                            String path = "/".equals(requestLineData[1]) ? "D:/resource/index.html" : "D:/resource" + requestLineData[1];
                            File file = new File(path);

                            bos = new BufferedOutputStream(socket.getOutputStream());

                            if (file.exists()) {
                                bis = new BufferedInputStream(new FileInputStream(file));
                                bos.write("HTTP/1.1 200 OK \r\n".getBytes());
                            } else {
                                bis = new BufferedInputStream(new FileInputStream("D:/resource/error.html"));
                                bos.write("HTTP/1.1 404 NOT FOUND \r\n".getBytes());
                            }

                            bos.write("\r\n".getBytes());

                            byte[] data = new byte[1024];
                            int length;
                            while ((length = bis.read(data)) != -1) {
                                bos.write(data, 0, length);
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } finally {


                            try {
                                if (bos != null)
                                    bos.close();
                                if (bis != null)
                                    bis.close();
                                if (br != null)
                                    br.close();
                                if (socket != null)
                                    socket.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                };
                service.submit(runnable);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
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
