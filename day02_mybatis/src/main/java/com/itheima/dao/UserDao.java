package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/2
 * @Description:
 */
public interface UserDao {
    /**
     *
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据用户Id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据用户的地址进行模糊查询
     * @param address
     * @return
     */
    List<User> findByAddress(String address);

    /**
     * 聚合函数的使用
     * @return
     */
    int findTotalCount();
}
