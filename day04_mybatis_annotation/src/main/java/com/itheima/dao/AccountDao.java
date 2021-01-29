package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/11
 * @Description:
 */
public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid", property = "user", one=@One(select="com.itheima.dao.UserDao.findOne",fetchType = FetchType.LAZY),javaType = User.class)
    })
    List<Account> findAll();

    /**
     * 根据uid查询用户
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findById(Integer uid);

}
