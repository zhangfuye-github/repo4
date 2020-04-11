package com.cmbc.test;

import com.cmbc.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/10
 * @Description:
 */
public class JDBCUtilsPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String name = scanner.nextLine();
            System.out.println("请输入密码：");
            String pws = scanner.nextLine();
            boolean b = new JDBCUtilsPractice().login2(name, pws);
            if (b) {
                System.out.println("登录成功");
            } else {
                System.out.println("密码或用户名错误！！！");
            }
        }

    }

    private boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        ResultSet resultSet = null;
        String sql = "select *from users where username='" + username + "' and password='" + password + "'";
        System.out.println(sql);
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.driverRegist();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }

        return false;
    }
    private boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.driverRegist();
            String sql = "select *from users where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }

        return false;
    }
}
