package com.lixin.Test2;

import javax.xml.ws.Response;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:ServerMain
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/6/006 18:01
 * @Version 1.0
 */
public class ServerMain {
    public static void main(String[] args) {
        try {
            int port = 9999;
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("服务器已启动，等待客户端连接...");

            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接！");

            //获取输入流和输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            //解析请求
            String request = reader.readLine();
            if (request != null) {
                String[] requestParts = request.split(" ");
                if (requestParts.length >= 2) {
                    String method = requestParts[0];
                    String path = requestParts[1];
                    String response;
                    if (path.equals("/")) {
                        response = getHTMLFileContent("index.html");
                    } else {
                        response = getHTMLFileContent("error.html");
                    }
                    //发送响应头
                    writer.write("HTTP/1.1 200 OK\r\n");
                    writer.write("Content-Type: text/plain\r\n");
                    writer.write("\r\n");
                    // 发送响应内容
                    writer.write(response);
                    writer.flush();
                }
            }
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("收到客户端发送的数据：" + line);
            }

            // 关闭资源
            writer.close();
            reader.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getHTMLFileContent(String filename) throws Exception {

        StringBuilder content = new StringBuilder();

        FileReader fr = new FileReader("E:\\resource\\index.html");
        BufferedReader reader = new BufferedReader(fr);
//        FileReader fr1 = new FileReader("E:\\resource\\error.html");
//        BufferedReader reader1 = new BufferedReader(fr1);

        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        return content.toString();
    }
}
