package cn.com.cmbc.service;

import cn.com.cmbc.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@Service
public interface UserService {
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
    @Insert("insert into user (age,username,PASSWORD,email,sex) values (#{user.age},#{user.username},#{user.PASSWORD},#{user.email},#{user.sex}")
    public void updateUser(User user);
}
