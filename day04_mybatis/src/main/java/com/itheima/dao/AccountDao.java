package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.QueryVO;
import com.itheima.domain.User;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/2
 * @Description:
 */
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

}
