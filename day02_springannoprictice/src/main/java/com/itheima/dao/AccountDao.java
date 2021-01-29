package com.itheima.dao;

import com.itheima.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
public interface AccountDao {
//    List<Account> findAll();

    List<Account> findAll() throws SQLException;

    Account findOne(Integer id) throws SQLException;

    void saveAccount(Account account) throws SQLException;

    void updateAccount(Account account);

    void deleteAccount(Integer id) throws SQLException;
}
