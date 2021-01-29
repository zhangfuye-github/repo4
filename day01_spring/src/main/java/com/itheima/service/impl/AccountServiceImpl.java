package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.util.BeanFactory;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/11
 * @Description:
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        //1.调用dao层的方法
        AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountdao");

        accountDao.saveAccount();
    }
}
