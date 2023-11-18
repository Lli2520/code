package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 例如，使用stmt和ps分别向表中插入10000条数据，观察使用时间
 */
public class StatementCompareTime {
    public static void main(String[] args) {
        String name = "赵高";
        Connection connection = null;
        Statement statement = null;
        PreparedStatement ps = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "bttc1", "bttc1");
            statement = connection.createStatement();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                statement.addBatch("insert  into team values (SEQ_TEST1.nextval,'" + name + "')");
            }
            statement.executeBatch();
            long end = System.currentTimeMillis();
            System.out.println("statement对象耗时：" + (end - start));

            ps = connection.prepareStatement("insert   into team values (SEQ_TEST1.nextval,?)");
            start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                ps.setString(1, name);
                ps.addBatch();
            }
            ps.executeBatch();
            end = System.currentTimeMillis();
            System.out.println("preparedStatement对象耗时：" + (end - start));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (statement != null)
                    statement.close();
                if (ps != null)
                    ps.close();

            } catch (Exception e) {

            }
        }
    }
}
