package com.briup.ch11;

import java.lang.String;

import java.io.*;
import java.util.Properties;

/**
 * @Author briup-adam
 * @Date 2023/10/24 上午10:49
 * @Description Properties本质上也是个map集合
 * @see Properties
 **/

public class PropertiesDemo {

    static class Stu {
        private String name;
        private int age;
        private String address;
        private String hobby;

        @Override
        public String toString() {
            return "Stu{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", hobby='" + hobby + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public Stu() {
        }

        public Stu(String name, int age, String address, String hobby) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.hobby = hobby;
        }
    }

    public static void main(String[] args) {
//创建读取文件的流
        FileInputStream fis = null;
        InputStreamReader isr = null;
        PrintWriter pw = null;
        try {

            fis = new FileInputStream("01code/src/01.properties");
            isr = new InputStreamReader(fis, "UTF8");
            Properties p = new Properties();
            //加载本地文件中的键值信息
            p.load(isr);

            String name = p.getProperty("stuName");
            int age = Integer.parseInt(p.getProperty("age"));
            Stu stu = new Stu(name, age, p.getProperty("address"), p.getProperty("hobby"));
            System.out.println(stu);
            //往集合中添加元素  磁盘文件不会有变化
            p.setProperty("gender", "男");
            p.setProperty("tel", "13312344321");
            p.setProperty("level", "low");
            //实例化输出流
            pw = new PrintWriter("01code/src/01.properties");
            //将数据持久化到文件
            p.store(pw, "");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fis != null) {
                    fis.close();
                }
                if (pw != null)
                    pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

