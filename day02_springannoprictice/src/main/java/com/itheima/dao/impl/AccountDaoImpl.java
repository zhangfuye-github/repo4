package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/12
 * @Description:
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;
    @Resource(name = "runner")
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll() throws SQLException {
        return runner.query("select * from account",new BeanListHandler<Account>(Account.class));

    }

    public Account findOne(Integer id) throws SQLException {
        return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),id);
    }

    public void saveAccount(Account account) throws SQLException {
        runner.update("insert into account (name,money) values (?,?)",account.getName(),account.getMoney());
    }

    public void updateAccount(Account account){
        try {
            runner.update("update account set name=?,money=? where id=?", account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAccount(Integer id) throws SQLException {
        runner.update("delete from account where id=?",id);

    }
}
