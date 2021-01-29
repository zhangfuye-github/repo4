package com.util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/9
 * @Description:
 */
public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/db201209?useunicuee=true& characterEncoding=utf8";
    static String username = "root";
    static String password = "123456";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps =null;
    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }
    public static int addUpdDel(String sql){
        int i = 0;
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }

        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs =  ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }
}
