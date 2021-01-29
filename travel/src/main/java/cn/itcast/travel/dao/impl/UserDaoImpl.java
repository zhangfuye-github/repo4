package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @Auther: 张夫业
 * @Date: 2020/10/15
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    //1.我们使用springtemplate进行连接数据库
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUser(String username) {
        //2.根据用户名进行用户的查询
//        System.out.println(username);
        User user1=null;
        try {
            String sql="select * from tab_user where username = ? ";
            user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {

        }
        return user1;
    }
    @Override
    public boolean saveUser(User user) {
        //创建sql
        String sql="insert into tab_user (username,password,name,birthday,sex,telephone,email,status,code) values (?,?,?,?,?,?,?,?,?)";
        //执行sql
        int update = template.update(sql, user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );
        if(update!=1){
            return false;
        }
        return true;
    }

    @Override
    public User findUserByCode(String code) {
        String sql="select * from tab_user where code=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        return user;
    }

    @Override
    public void updateUser(String username, String status) {
        String sql="update tab_user set status = ? where username=?";
        template.update(sql,status,username);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = null;
        try {
            String sql="select * from tab_user where username=? and password=?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByName(String user) {
        User user1 = null;
        try {
            String sql="select * from tab_user where name=?";
            user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user1;
    }
}
