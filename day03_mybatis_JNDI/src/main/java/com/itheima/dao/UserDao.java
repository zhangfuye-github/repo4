package com.itheima.dao;

import com.itheima.domain.QueryVO;
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
     * 根据条件进行查询
     * @param user
     * @return
     */
    List<User> findByConditions(User user);

    /**
     * 根据用户输入的id集合进行查询
     * @param vo
     * @return
     */
    List<User> findByIds(QueryVO vo);
}
