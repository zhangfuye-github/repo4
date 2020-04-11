package com.cmbc.jdbc;

import com.cmbc.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/9
 * @Description:
 */
public class JDBCDemo02 {
    public static void main(String[] args) {
        List<Emp> all = new JDBCDemo02().findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }
        System.out.println(all.size());
    }
    //这是用来查询所有数据库表所有信息的类
    public List<Emp> findAll() {
        Emp emp = null;
        List<Emp> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1", "root", "123456");
            //3.创建SQL
            String sql = "select * from emp";
            //4.获取执行SQL的对象
            statement = connection.createStatement();
            //5.执行SQL
            resultSet = statement.executeQuery(sql);
            //6.处理结果
            while (resultSet.next()) {
                /*      private int id;
                        private String ename;
                        private int job_id;
                        private int mgr;
                        private Date joindate;
                        private double salary;
                        private double bonus;
                        private int dept_id;
                */
                emp=new Emp();
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                list.add(emp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
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


        return list;

    }
}
