package com.briup.ch12;

import java.lang.String;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午11:19
 * @Description 现将文件读取
 * 根据文件内容创建对象
 * 将创建出来的对象通过网络发送给服务器
 **/

public class TcpClientDemo4 {
    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("/Users/adam/code/idea-workspace/bttc-code/01code/src/com/briup/ch12/student.txt");
            br = new BufferedReader(fr);
            String line = null;
            ArrayList<Student> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] msgs = line.split("[-]");
                Student student = new Student(msgs[0], Integer.parseInt(msgs[1]), msgs[2]);
                list.add(student);
            }
            Socket socket = new Socket("10.138.124.21", 9088);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(list);
            socket.shutdownOutput();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
