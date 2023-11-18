package com.briup.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidGetConnection {
    public  static Properties loadProperties(){
        Properties p = new Properties();
        //使用类加载器 加载本地文件 并作为stream
        InputStream stream = DruidGetConnection.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            p.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public  static  Connection getConnection() throws Exception {
        //创建数据连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(loadProperties());
        //通过连接池获取 链接对象
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}
