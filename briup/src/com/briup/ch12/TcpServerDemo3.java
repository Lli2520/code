package com.briup.ch12;

import java.lang.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午10:33
 * @Description 聊天室
 **/

public class TcpServerDemo3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ServerSocket server = new ServerSocket(10111);
            while (true) {
                Socket socket = server.accept();

                BufferedReader br = null;
                InputStreamReader isr = null;
                PrintWriter pw = null;
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                pw = new PrintWriter(socket.getOutputStream(), true);

                String address = socket.getInetAddress().toString();
                System.out.println(address);
                while (true) {
                    String line = br.readLine();
                    System.err.println(address + ":" + line);
                    if (line.equals("bye")) {
                        break;
                    }
                    //获取用户输入
                    String msg = scanner.next();
                    pw.println(msg);
                    pw.flush();
                    System.out.println("我：" + msg);
                    if (msg.equals("bye")) {
                        break;
                    }

                }
                socket.shutdownOutput();
                socket.shutdownInput();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
