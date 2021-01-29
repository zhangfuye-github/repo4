package cn.com.cmbc.dao.impl;

import cn.com.cmbc.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
@Repository
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println(456);
    }
}
