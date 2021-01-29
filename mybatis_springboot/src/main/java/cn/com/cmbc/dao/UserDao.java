package cn.com.cmbc.dao;

import cn.com.cmbc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@Mapper
public interface UserDao {
    /**
     * 查询所有的用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();
}
