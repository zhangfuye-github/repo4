package com.inspur.dao;

import com.inspur.domain.User;

import java.sql.SQLException;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/22
 * @Description:
 */
public class UserLogin {
//    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public boolean userLogin(User userda) throws SQLException, ClassNotFoundException {
        String sql="select * from user where name=? and password=?";
        return new JDBCDemo().method(sql, userda);
//        try {
//            User user = template.queryForObject(sql,
//                    new BeanPropertyRowMapper<User>(User.class),
//                    userda.getName(), userda.getPassword());
//            return user;
//        } catch (DataAccessException e) {
//            e.printStackTrace();//记录日志
//            return null;
//        }
    }
}
