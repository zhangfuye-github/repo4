package com.cmbc.test;

import com.cmbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/11
 * @Description:
 */
public class JDBCTransaction {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        try {
            connection = JDBCUtils.driverRegist();
            connection.setAutoCommit(false);
            String sql1="update account set balance=balance-? where id=?";
            String sql2="update account set balance=balance+? where id=?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement.setDouble(1,500);
            preparedStatement.setInt(2,1);
            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,2);
            preparedStatement.execute();
//            int i = 3 / 0;
            preparedStatement1.execute();
            connection.commit();
        } catch (Exception e) {
            try {
                if (connection!=null){
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement);
            JDBCUtils.close(connection,preparedStatement1);
        }
    }
}
