package com.inspur.dao;

import com.inspur.domain.User;

import java.sql.*;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/22
 * @Description:
 */
public class JDBCDemo {
    public boolean method(String sql, User user) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day14","root","123456");
        //3.创建执行sql的对象
//        Statement statement = connection.createStatement();
        //4.创建sql
//        String sql="select * from user where name=? and password=?";

        PreparedStatement statement = connection.prepareStatement(sql);

        //5.执行sql
//        ResultSet resultSet = statement.executeQuery(sql);
        statement.setString(1,user.getName());
        statement.setString(2,user.getPassword());
//        ResultSet resultSet = statement.executeQuery();
        ResultSet resultSet = statement.executeQuery();
        System.out.println(user);
//        System.out.println(b);
        //6.处理结果
        while(resultSet.next()) {
            String username = resultSet.getString("name");
            String password = resultSet.getString("password");
            System.out.println(username);
            System.out.println(password);
            return true;
        }
        //7.关闭资源
        statement.close();
        connection.close();
        return false;
    }
}
