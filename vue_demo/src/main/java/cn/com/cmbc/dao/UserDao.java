package cn.com.cmbc.dao;

import cn.com.cmbc.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:操作user表的到接口
 */
@Repository
public interface UserDao {
    /**
     * 查询所有用户的方法
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    /**
     * 保存用户
     * @param user
     */
//    @Insert("insert into user (age,username,PASSWORD,email,sex) values (#{user.age},#{user.username},#{user.PASSWORD},#{user.email},#{user.sex}")
    @Update("update user set age=#{age},username=#{username},PASSWORD=#{password},email=#{email},sex=#{sex} where id=#{id}")
    public void updateUser(User user);
}
