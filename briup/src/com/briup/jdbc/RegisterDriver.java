package com.briup.jdbc;

import oracle.jdbc.driver.OracleDriver;

/**
 * 注册驱动   实际上是要驱动类加载到jvm 才能被注册到驱动管理器
 */

public class RegisterDriver {
    public static void main(String[] args) {
        //创建对象 让类主动加载
        OracleDriver oracleDriver = new OracleDriver();
        //通过Class的静态方法  forName
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
