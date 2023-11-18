package com.briup.ch12;

import java.lang.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午10:44
 * @Description
 **/

public class TcpClientDemo3 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("10.138.124.21", 10111);
            System.out.println("已连接到服务器 请开始聊天 若需要结束聊天 请输入 bye ");
            InputStreamReader isr=new InputStreamReader(socket.getInputStream());
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pw=new PrintWriter(socket.getOutputStream());

            while (true){
                String msg = scanner.next();
                pw.println(msg);
                pw.flush();
                System.out.println("我："+msg);
                if (msg.equals("bye"))
                    break;
                String line = br.readLine();
                System.out.println(socket.getInetAddress().toString()+":"+line);
                if (line.equals("bye"))
                    break;

            }
            socket.shutdownInput();
            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
