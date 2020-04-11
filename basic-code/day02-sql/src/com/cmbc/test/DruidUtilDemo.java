package com.cmbc.test;

import com.cmbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/11
 * @Description:
 */
public class DruidUtilDemo {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from users";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getRow());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
    }
}
