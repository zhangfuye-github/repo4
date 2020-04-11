package com.cmbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/11
 * @Description:
 */
public class JDBCUtils {
    //这是javaDruid连接池技术的工具类，我们使用JDBC时，
    // 只需要使用SQL就可以，因此其获取数据库连接池对象
    //关闭流等一系列操作都可以省略
    //首先抽取一个获取连接的方法
    private static DataSource dataSource=null;
    static{
        Properties pro = new Properties();
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        //1.导入jar包
        //2.创建配置文件
        //3.加载配置文件
        //4.获取连接
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //2.获取连接池
    public static DataSource getDataSource(){
        return dataSource;
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
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(connection,statement);
    }
}
