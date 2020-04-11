package com.cmbc.jdbc;

import java.sql.*;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/9
 * @Description:
 */
public class JDBCDemo1 {
    public static void main(String[] args) {
//        1.导入jar包
//        2.创建驱动
        Connection connection = null;
        Statement connectionStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //        3.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db2", "zfy", "123456");
//        4.创建可执行SQL
            String s = "select * from account";
//        5.获取执行sql的对象
            connectionStatement = connection.createStatement();
//        6.执行SQL
            resultSet = connectionStatement.executeQuery(s);
//        7.处理返回结果
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") +
                        "--" + resultSet.getString("name") +
                        "--" + resultSet.getString("balance"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //        8.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connectionStatement != null) {
                try {
                    connectionStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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