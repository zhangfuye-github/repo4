package cn.com.cmbc.service.impl;

import cn.com.cmbc.dao.AccountDao;
import cn.com.cmbc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
//@Component的参数是value，为当前类名小写。
@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Autowired
    @Qualifier("account")
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
        System.out.println(123456);
    }

    /**
     * 保存接口的方法实现
     */
    public void saveAccount() {
        accountDao.saveAccount();
//        System.out.println(123);
    }
}
