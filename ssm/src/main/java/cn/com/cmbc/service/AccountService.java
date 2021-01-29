package cn.com.cmbc.service;

import cn.com.cmbc.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/23
 * @Description:
 */
@Service
public interface AccountService {
    /**
     * 查询所有账户的方法
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户的方法
     * @param account
     */
    void saveUser(Account account);
}
