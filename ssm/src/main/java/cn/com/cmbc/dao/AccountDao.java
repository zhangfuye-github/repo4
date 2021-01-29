package cn.com.cmbc.dao;

import cn.com.cmbc.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/23
 * @Description:
 */
@Repository
public interface AccountDao {
    /**
     * 查询所有账户的方法
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户的方法
     * @param account
     */
    @Insert("insert into account (name,money) values(#{name},#{money})")
    void saveUser(Account account);
}
