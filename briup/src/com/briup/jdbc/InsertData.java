package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

/**
 * jdbc 插入数据到表
 */
public class InsertData {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "bttc1", "bttc1");
            System.out.println(connection.getAutoCommit());
            //关闭自动提交
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sql = "insert into team values(seq_test1.nextval,'tom')";
//            int i1 = statement.executeUpdate(sql);
            for (int i = 0; i < 50; i++) {
                statement.addBatch(sql);
            }
            int[] ints = statement.executeBatch();
            System.out.println(Arrays.toString(ints));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (statement != null)
                    statement.close();

            } catch (Exception e) {

            }
        }
    }
}
