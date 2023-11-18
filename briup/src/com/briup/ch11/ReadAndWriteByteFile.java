package com.briup.ch11;

import java.lang.String;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author briup-adam
 * @Date 2023/10/19 下午3:03
 * @Description
 * @see  FileInputStream  读文件
 * @see FileOutputStream  写文件
 **/

public class ReadAndWriteByteFile {
    public static void read() {
        //声明流
        FileInputStream fis=null;
        try {
            //创建流
            fis=new FileInputStream("01code/src/十年.txt");
            //使用流
            /**
             * 1. 一个字节一个字节的读
             */
//            int val=0;
//            while ((val=fis.read())!=-1){
//                System.out.println(val);
//            }
            /**
             * 2.将读到的内容放到数组里
             */
//            byte [] b=new byte[80];
//            //接收 每一次读到的字节个数
//            int len=0;
//            while ((len=fis.read(b))!=-1){
//                //使用byte数组构建字符串
//                String s = new String(b, 0, len);
//                System.out.println(s);
//            }


            byte [] b=new byte[80];
            //接收 每一次读到的字节个数
            int len=0;
            while ((len=fis.read(b,0,b.length))!=-1){
                //使用byte数组构建字符串
                String s = new String(b, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static  void write(){
        String s = "又一个四季在轮回 而我一无所获的坐在街头；理想今年你几岁！";
        //字符串直接转成字节数组
        byte[] b = s.getBytes();
        //声明
        FileOutputStream fos=null;
        try {
            //创建
            // 如果文件不存在   自动创建文件
            //如果文件已经存在  覆盖之前的内容
            //如果文件已经存在 想追加到文件  使用两参构造器 第二参数设置为true
            fos=new FileOutputStream("01code/src/10-19.txt",true);
            //使用流
            /**
             * 1.一个字节一个字节的写出
             */
//            for (byte b1 : b) {
//                fos.write(b1);
//            }
            /**
             * 直接写出一个数组
             */
//            fos.write(b);
            //写出指定数组的部分字节
            fos.write(b,0,b.length/2);
            //刷新
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void  readAndWrite(){
        //声明
        FileInputStream fis=null;
        FileOutputStream fos=null;
        //创建
        try {
            fis=new FileInputStream("01code/src/1.jpg");
            fos=new FileOutputStream("01code/src/3.jpg");
            //使用
            byte [] b=new byte[80];
            int len=0;
            while((len=fis.read(b))!=-1){
                fos.write(b,0,len);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (fis!=null) {
                try {
                    fis.close();
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
//        read();
//        write();
        readAndWrite();
    }
}
