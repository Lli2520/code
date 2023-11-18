package com.briup.ch11;

import java.lang.String;

import java.io.*;

/**
 * @Author briup-adam
 * @Date 2023/10/23 上午11:21
 * @Description
 **/

public class ReadAndWriteObject {

    public static void main(String[] args) {
        Student stu = new Student("闫昊", 20,"123456");
        try {
            writeObject(stu, "01code/src/stu.txt");
            Object o = readObject("01code/src/stu.txt");

            System.out.println(stu);
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //这是泛型方法
    static <T> void writeObject(T t, String path) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        fos = new FileOutputStream(path);
        oos = new ObjectOutputStream(fos);

        //写出对象
        oos.writeObject(t);
        //关闭流
        if (oos != null)
            oos.close();
        if (fos != null)
            fos.close();

    }

    public static <T> T readObject(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        fis = new FileInputStream(path);
        ois = new ObjectInputStream(fis);
        //读对象
        Object o = ois.readObject();
//        Object o1 = ois.readObject();
//        System.out.println(o);

        if (ois != null)
            ois.close();
        if (fis != null)
            fis.close();
        return (T) o;
    }
}
