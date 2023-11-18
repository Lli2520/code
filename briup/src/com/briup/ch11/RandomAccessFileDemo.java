package com.briup.ch11;

import java.lang.String;

import java.io.*;

/**
 * @Author briup-adam
 * @Date 2023/10/24 上午10:01
 * @Description
 **/

public class RandomAccessFileDemo {
    public static void replace(String path) {
        File file = new File(path);
        RandomAccessFile rw = null;
        ByteArrayOutputStream baos = null;
        try {
            rw = new RandomAccessFile(file, "rw");
            baos = new ByteArrayOutputStream();
            //调到第六个字节后面
            rw.seek(6);
            rw.write("briup".getBytes());
            //回到起始位置
            rw.seek(0);
            int len = 0;
            byte[] b = new byte[8];
            while ((len = rw.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            System.out.println(baos.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rw != null) {
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insert(String path, int pos) throws Exception {
        File file = new File(path);
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        byte[] insertVal = "adam".getBytes();
        //先跳过制定字节数
        rw.seek(pos);
        byte[] b = new byte[(int) (file.length() - pos)];
        rw.read(b);
        rw.seek(pos);
        rw.write(insertVal);
        rw.write(b);
        rw.close();
    }

    public static void main(String[] args) {
        try {
            insert("01code/src/file.txt", 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
