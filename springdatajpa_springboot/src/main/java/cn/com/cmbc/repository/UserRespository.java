package cn.com.cmbc.repository;

import cn.com.cmbc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
public interface UserRespository extends JpaRepository<User,Long> {
    public List<User> findAll();
}
