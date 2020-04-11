package com.cmbc.demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/11
 * @Description:
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
//        Druid数据库连接池，是阿里巴巴提供的连接池技术
        //1.首先导入jar包
        //2.创建properties配置文件
        //3.加载配置文件，通过类加载器加载
        Properties pro = new Properties();
        InputStream inputStream = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(inputStream);
        //4.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        //5.获取连接
        Connection connection = dataSource.getConnection();
        dataSource.getConnection();
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource.getConnection());
        //6.创建执行对象
        Statement statement = connection.createStatement();
        //7.创建执行SQL
        String sql="select *from users";
        //8.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //9.处理结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getRow());
        }
        //10.关闭资源
        connection.close();
    }
}
