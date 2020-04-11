package com.cmbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/9
 * @Description:
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //使用jdbc的步骤：
        //此处要知到jdbc是一个接口，是一个规范，而mysql的jar包是一个实现类，是mysql的驱动
        //注册驱动这一步，可以不进行。因为注册驱动这一步在获取连接时也会注册驱动。
//        1.导入jar包
//        2.创建驱动
//        Class.forName("com.mysql.jdbc.Driver");
//        3.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db2", "zfy", "123456");
//        4.创建可执行SQL
        String s="update account set balance=1500 where id =1";
//        5.获取执行sql的对象
        Statement connectionStatement = connection.createStatement();
//        6.执行SQL
        int i = connectionStatement.executeUpdate(s);
//        7.处理返回结果
        System.out.println(i);
//        8.释放资源
        connection.close();
        connectionStatement.close();
    }
}
