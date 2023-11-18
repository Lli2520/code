package com.briup.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 使用jdbc 获取数据库 元数据
 */

public class DataBaseMetaData {
    public static void main(String[] args) {
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(DruidGetConnection.loadProperties());
            Connection connection = dataSource.getConnection();
            //通过链接 获取数据库的元数据
            DatabaseMetaData metaData = connection.getMetaData();
//            获取数据库名字
            System.out.println(metaData.getDatabaseProductName());
//            获取数据库详情 包括数据库名字  版本
            System.out.println(metaData.getDatabaseProductVersion());
//            获取数据库大版本
            System.out.println(metaData.getDatabaseMajorVersion());
//            获取数据库小版本
            System.out.println(metaData.getDatabaseMinorVersion());

            //通过元数据获取数据库中的的对象信息
            ResultSet tables = metaData.getTables(null, "BTTC1", null, null);
            //获取结果集元数据
            ResultSetMetaData metaData1 = tables.getMetaData();
            //获取结果集一共多少个列
            int count = metaData1.getColumnCount();
            //处理结果集
            while (tables.next()) {
                //获取结果集的每一个列
                for (int i = 1; i <= count; i++) {
                    //获取结果集中的列的名字
                    String name = metaData1.getColumnName(i);
                    //获取结果集中的列的类型
                    int type = metaData1.getColumnType(i);
                    String val = tables.getString(name);
                    System.out.println(name + ":" + val);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
