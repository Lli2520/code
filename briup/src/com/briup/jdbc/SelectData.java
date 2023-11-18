package com.briup.jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * 使用jdbc进行数据查询
 * 1.注册驱动
 * 2.获取连接
 * 3.创建statement
 * 4.执行sql
 * 5.处理结果集 （当且仅当执行sql语句为select子句）
 * 6.关闭资源
 */
public class SelectData {
    public static void main(String[] args) {
        ArrayList<Emp> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bttc1", "bttc1");
            statement = connection.createStatement();
            String sql = "select id,last_name,salary,title from s_emp";
            //执行sql  获取结果集
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                id = resultSet.getInt("id");
//                System.out.print(id + "\t");
                String lastName = resultSet.getString("last_name");
//                System.out.print(lastName + "\t");
                int salary = resultSet.getInt("salary");
//                System.out.print(salary + "\t");
                String title = resultSet.getString("title");
//                System.out.println(title + "\t");
                Emp emp = new Emp(id, lastName, salary, title);
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (statement != null)
                    statement.close();
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list.forEach(System.out::println);
        }
    }
}
