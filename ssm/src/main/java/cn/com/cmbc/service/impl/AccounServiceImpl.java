package cn.com.cmbc.service.impl;

import cn.com.cmbc.dao.AccountDao;
import cn.com.cmbc.domain.Account;
import cn.com.cmbc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/23
 * @Description:
 */
@Service
public class AccounServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层:List<Account>方法执行了........");
        List<Account> all = accountDao.findAll();
//        for (Account account : all) {
//            System.out.println(account);
//        }
        return all;
    }

    @Override
    public void saveUser(Account account) {
        System.out.println("业务层:saveUser方法执行了........");
        accountDao.saveUser(account);
    }
}
