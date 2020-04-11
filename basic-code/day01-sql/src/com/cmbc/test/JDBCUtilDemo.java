package com.cmbc.test;

import com.cmbc.domain.Emp;
import com.cmbc.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/10
 * @Description:
 */
public class JDBCUtilDemo {
    public static void main(String[] args) {
        String sql = "select *from emp";
        findAll(sql);
    }

    private static void findAll(String sql) {
        Connection connection = JDBCUtils.driverRegist();
        Statement statement = null;
        Emp emp = null;
        List<Emp> list = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
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
                emp = new Emp();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        for (Emp emp1 : list) {
            System.out.println(emp1);
        }
    }
}
