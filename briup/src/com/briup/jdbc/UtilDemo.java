package com.briup.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

public class UtilDemo {
    public static void main(String[] args) {
        try {
            List<Dept> depts = JDBCUtil.executeDQL("select *  from s_dept", new Function<ResultSet, Dept>() {
                @Override
                public Dept apply(ResultSet resultSet) {
                    int id = 0;
                    try {
                        id = resultSet.getInt("id");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String name = null;
                    try {
                        name = resultSet.getString("name");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    int regionId = 0;
                    try {
                        regionId = resultSet.getInt("region_id");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return new Dept(id, name, regionId);

                }
            });
            depts.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
