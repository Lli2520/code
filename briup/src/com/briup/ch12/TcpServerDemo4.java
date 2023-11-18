package com.briup.ch12;

import java.lang.String;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午11:25
 * @Description
 **/

public class TcpServerDemo4 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9088);
            while (true) {
                Socket socket = server.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                List<Student> list = (List<Student>) ois.readObject();
                System.out.println(list);
                socket.shutdownInput();
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
