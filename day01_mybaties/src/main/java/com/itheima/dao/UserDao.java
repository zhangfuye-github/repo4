package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/30
 * @Description:
 */
public interface UserDao {
    /**
     * 查询所有的用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
    @Select("select count(*) from user")
    Integer findCount();
}
