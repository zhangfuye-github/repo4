package com.test.springcloud.dao;

import com.test.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Mapper
@Component
public interface PaymentDao {
//    插入
    public int insert(Payment payment);
    //根据ID进行查询
    public Payment getPaymentById(@Param("id") Long id);
}
