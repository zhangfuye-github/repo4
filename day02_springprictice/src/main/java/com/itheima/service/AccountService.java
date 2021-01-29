package com.itheima.service;

import com.itheima.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:Account账户的service层接口
 */
public interface AccountService {
    /**
     * 查询所有的方法
     * @return
     */
    List<Account> findAll() throws SQLException;

    /**
     * 根据用户的id查询账户
     * @param id
     * @return
     */
    Account findOne(Integer id) throws SQLException;

    /**
     * 添加账户
     * @param account
     */
    void saveAccount(Account account) throws SQLException;

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    void deleteAccount(Integer id) throws SQLException;
}
