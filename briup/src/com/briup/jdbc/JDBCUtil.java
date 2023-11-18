package com.briup.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

/**
 * 基于数据库连接池做工具类
 */
public class JDBCUtil {
    private static DataSource dataSource;

    //跟随类加载 只执行一次
    static {
        Properties p = new Properties();
        InputStream stream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            p.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement;
    }

    public static PreparedStatement getStatement(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps;
    }

    public static void close(Connection connection, Statement statement, ResultSet set) throws SQLException {
        if (connection != null)
            connection.close();
        if (statement != null)
            statement.close();
        if (set != null)
            set.close();
    }

    public static void close(Connection connection, Statement statement) throws SQLException {
        close(connection, statement, null);
    }


    public static void executeDDL(String sql) throws SQLException {
        Statement statement = getStatement();
        statement.execute(sql);
    }

    public static int executeDML(String sql) throws SQLException {
        PreparedStatement statement = getStatement(sql);
        int i = statement.executeUpdate();
        return i;
    }

    public static <T> List<T> executeDQL(String sql, Function<ResultSet, T> function) throws SQLException {
        ArrayList list = new ArrayList();
        PreparedStatement ps = getStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            T t = function.apply(resultSet);
            list.add(t);
        }
        return list;
    }
}
