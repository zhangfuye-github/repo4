package com.cmbc.test;

import com.cmbc.domain.Emp;
import com.cmbc.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/11
 * @Description:
 */
public class TemplatePrictice {
    //.Spring JDBC是对jdbc封装的工具类，
    //使用1.导入jar包
    //2.创建对象
    /*
    1.修改1号数据的 salary为 10000
    2.添加一条记录
    3.删除刚才添加的记录
    4.查询id为1的记录，将其封装为Map集合
    5.查询所有记录，将其封装为List
    6.查询所有记录，将其封装为Emp对象的List集合
    7.查询总记录数
    */
    private DataSource ds = JDBCUtils.getDataSource();
    JdbcTemplate template = new JdbcTemplate(ds);

    @Test
    public void test1() {
//        1.修改1号数据的 salary为 10000
        String sql = "update emp set salary=10000 where id=?";
        int update = template.update(sql, 1001);
        System.out.println(update);
    }

    //    2.添加一条记录
    @Test
    public void test2() {
        String sql = "insert emp (id,ename,salary) values (?,?,?)";
        int update = template.update(sql, 1015, "张三", 1000);
        System.out.println(update);
    }

    @Test
    public void test3() {
        String sql = "delete from emp where id=?";
        int update = template.update(sql, 1015);
        System.out.println(update);
    }

    // 4.查询id为1的记录，将其封装为Map集合
    @Test
    public void test4() {
        String sql = "select * from emp where id=?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    //    5.查询所有记录，将其封装为List
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    //    6.查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test7() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    //     7.查询总记录数
    @Test
    public void test8() {
        String sql = "select count(*) from emp";
        Integer integer = template.queryForObject(sql, int.class);
        System.out.println(integer);
    }
}
