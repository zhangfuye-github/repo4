package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/18
 * @Description:
 */
public interface AccountDao {
    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 根据用户名查询账户
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新账户
     * @param id
     */
    void updateAccount(Integer id);
}
