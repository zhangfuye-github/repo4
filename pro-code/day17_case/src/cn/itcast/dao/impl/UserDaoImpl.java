package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/20
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    //本次使用的是Springtemplate，进行数据库的连接
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values (null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateUserById(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        jdbcTemplate.update(sql,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail(),
                user.getId()
        );
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.条件有了，然后根据条件进行查询，这个条件是个变量，所以要有循环追加
        String sql = "select count(*) from user where 1=1";
        //2.定义一个StringBuilder，使用该对象的方法
        StringBuilder sb = new StringBuilder(sql);
        //3.追加SQL
        Set<String> keySet = condition.keySet();
        ArrayList<Object> parames = new ArrayList<>();
        Integer totalCount=0;
        if(condition.size()>0){
            for (String s : keySet) {
                String s1 = condition.get(s)[0];
                if(!"rows".equals(s)&&!"currentPage".equals(s)){
                    if (s1 !=null && !"".equals(s1)){
                        sb.append(" and " + s + " like ? ");
                        System.out.println(s1);
                        parames.add("%" + s1 + "%");
                    }
                }
            }
            String sSQL = sb.toString();
            System.out.println(sSQL);
            totalCount= jdbcTemplate.queryForObject(sSQL, Integer.class, parames.toArray());
//        System.out.println("总记录数为:"+totalCount);
            return totalCount;
        }else{
            totalCount= jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("总记录数为:"+totalCount);
            return totalCount;
        }
    }
    @Override
    public List<User> findUserByPage(int intRows, int startRow, Map<String, String[]> condition) {
        String sql = "select * from user where 1=1";
        List<User> users = null;
        //2.定义一个StringBuilder，使用该对象的方法
        StringBuilder sb = new StringBuilder(sql);
        //3.追加SQL
        Set<String> keySet = condition.keySet();
        ArrayList<Object> parames = new ArrayList<>();
        if(condition.size()>0){
            for (String s : keySet) {
                String s1 = condition.get(s)[0];
                System.out.println(s);
                if(!"rows".equals(s)&&!"currentPage".equals(s)){
                    if (s1 !=null && !"".equals(s1)){
                        sb.append(" and " + s + " like ? ");
                        System.out.println(s1);
                        parames.add("%" + s1 + "%");
                    }
                }
            }
            sb.append(" limit ?,?");
            parames.add(startRow);
            parames.add(intRows);
            String sSQL = sb.toString();
            System.out.println(sSQL);
            users= jdbcTemplate.query(sSQL, new BeanPropertyRowMapper<User>(User.class),parames.toArray());
            return users;
        }else{
            sb.append(" limit ?,?");
            String sSQL = sb.toString();
            users = jdbcTemplate.query(sSQL, new BeanPropertyRowMapper<User>(User.class), startRow, intRows);
            return users;
        }
    }
}
