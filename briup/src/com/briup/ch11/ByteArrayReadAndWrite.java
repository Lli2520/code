package com.briup.ch11;


import java.lang.String;

import java.io.*;
import java.util.Scanner;

/**
 * @Author briup-adam
 * @Date 2023/10/19 下午4:36
 * @Description
 **/

public class ByteArrayReadAndWrite {
    /**
     * 使用字节数组输出流的测试案例
     */
    public static  void  write(){
        //声明
        FileInputStream fis=null;
        ByteArrayOutputStream baos=null;
        try {
            //创建
            fis=new FileInputStream("01code/src/十年.txt");
            baos=new ByteArrayOutputStream();
            //使用流
            byte [] b=new  byte[80];
            int len=0;

            while((len=fis.read(b))!=-1){
                baos.write(b,0,len);
            }
            baos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null)
                    fis.close();
                if (baos!=null)
                    baos.close();
            }catch (Exception e){

            }
            //获取字节数组输出流中 字节数组的内容
//            byte[] b = baos.toByteArray();
//            String string = new String(b,0,b.length);
//            System.out.println(string);
            //等同于上边的两行代码
            String s = baos.toString();
            System.out.println(s);
        }
    }

    /**
     * 字节数组输入流的案例
     */

    public static  void  read(){
        System.out.println("请从键盘输入一句你喜欢的歌词！");
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        byte[] words = next.getBytes();

        ByteArrayInputStream bais=null;
        FileOutputStream fos=null;

        try {
            bais=new ByteArrayInputStream(words);
            fos=new FileOutputStream("01code/src/你的背包.txt");
            byte b[] =new byte[80];
            int len=0;
            while ((len=bais.read(b))!=-1){
                fos.write(b,0,len);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bais!=null) {
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
//        write();
//        read();
        System.out.println("你好");

        try {
            System.setOut(new PrintStream("01code/src/你的背包.txt"));
            System.out.println("再见");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
