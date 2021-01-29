package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/6
 * @Description:
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results( id="usermap", value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "id",property = "list",many=@Many(select = "com.itheima.dao.AccountDao.findById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据用户的id更新用户
     * @param user
     * @return
     */
    @Update("update user set username=#{username},sex=#{userSex},birthday=#{userBirthday},address=#{userAddress} where id=#{userId}")
    @ResultMap("usermap")
    void  updateUserById(User user);

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user (username,sex,address,birthday) values (#{username},#{userSex},#{userAddress},#{userBirthday})")
    @ResultMap("usermap")
    void addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id=#{userId}")
    @ResultMap("usermap")
    void deleteUser(Integer id);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @Select("Select * from user where id=#{userId}")
    @ResultMap("usermap")
    User findOne(Integer id);

    /**
     * 根据用户名模糊查询用户
     * @param username
     * @return
     */
    @Select("select * from user where username like '%${value}%'")
    @ResultMap("usermap")
    List<User> findUserByName(String username);

    /**
     * 查询总的数量
     * @return
     */
    @Select("select count(*) from user")
    Integer findTotalCount();
}
