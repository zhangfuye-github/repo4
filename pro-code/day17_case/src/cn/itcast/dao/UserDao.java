package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/20
 * @Description:<用户操作的dao
 */
public interface UserDao {
    public List<User> findAll();
}
