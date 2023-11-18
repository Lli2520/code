package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 获取与数据库的连接
 */
public class GetConnection {
    public static void main(String[] args) {
        try {
            //注册驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            while (true) {
                //获取连接
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bttc1", "bttc1");
                System.out.println(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
