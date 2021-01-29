package com.test.springcloud.service;

import com.test.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Service
public interface PaymentService {
    public int insert(Payment payment);
    public Payment getPaymentById(Long id);
}
