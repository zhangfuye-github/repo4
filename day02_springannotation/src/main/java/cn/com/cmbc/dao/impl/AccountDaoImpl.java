package cn.com.cmbc.dao.impl;

import cn.com.cmbc.dao.AccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
@Repository("account")
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println(123);
    }
}
