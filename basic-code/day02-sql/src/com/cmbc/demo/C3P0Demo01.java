package com.cmbc.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @Auther: 张夫业
 * @Date: 2020/4/11
 * @Description:
 */
public class C3P0Demo01 {
    public static void main(String[] args) {
        //1.创建连接池对象
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        //2.获取数据库连接
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getRow());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
