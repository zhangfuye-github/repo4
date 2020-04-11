package com.cmbc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/10
 * @Description:
 */
public class JDBCUtils {
    //1.使用jdbc时，存在大量重复的代码，因此我们可以进行代码的封装抽取
    //工具类当中，一般抽取为静态方法，可以通过类名直接调用
    //1.注册驱动
    private static String user ;
    private static String url ;
    private static String password ;
    private static String driver ;
    static{
        Properties pro = new Properties();
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        URL pro1 = classLoader.getResource("pro.properties");
        String path = pro1.getPath();
        try {
            pro.load(new FileReader(path));
            user = pro.getProperty("root");
            url = pro.getProperty("url");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //2.获取连接
    public static Connection driverRegist(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //3.关闭资源
    public static void close(Connection connection, Statement statement){
        if (statement != null) {
            try {
                statement.close();
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
    //方法重载
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
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
