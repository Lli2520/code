package com.briup.ch12;


import java.lang.String;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午10:10
 * @Description  上传文件给服务器并接受反馈
 **/

public class TcpClientDemo2 {
    public static void main(String[] args) {
        Socket socket=null;
        FileInputStream fis=null;

        try {
            //创建客户端
            socket= new  Socket("127.0.0.1",10086);
            fis= new FileInputStream("/Users/adam/code/idea-workspace/bttc-code/01code/src/1.jpg");
            //准备通过socket写出文件
            OutputStream os = socket.getOutputStream();
            int len=0;
            byte [] b=new byte[1024];
            while((len=fis.read(b))!=-1){
                os.write(b,0,len);
            }
            os.flush();
            socket.shutdownOutput();
            //准备接收 服务器给到的反馈
            InputStream is = socket.getInputStream();
            while ((len=is.read(b))!=-1){
                System.out.println(new String(b,0,len));
            }
            socket.shutdownInput();

            fis.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
