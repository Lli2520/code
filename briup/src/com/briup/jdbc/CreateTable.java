package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc 建表
 * jdbc 六大步骤
 * 1.注册驱动
 * 2.获取连接
 * 3.创建statement对象
 * 4.执行sql
 * 5.处理结果集 （当执行的sql是 select语句）
 * 6.关闭资源
 */
public class CreateTable {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bttc1", "bttc1");
            //创建statement对象
            statement = connection.createStatement();
            //执行sql
            String sql = "create  table team(" +
                    "id number primary key," +
                    "name varchar2(100)" +
                    ")";
            boolean b = statement.execute(sql);
            //处理结果集 b 为true 说明执行的是 select
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
