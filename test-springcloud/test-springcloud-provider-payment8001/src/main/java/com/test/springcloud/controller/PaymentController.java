package com.test.springcloud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springcloud.entities.CommonResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    Log log = LogFactory.getLog(Slf4j.class);
    
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/insert")
    public   CommonResult insert(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("====== 插入结果：" + result);
        if(result > 0) {
            return new CommonResult(200, "插入数据成功，服务端口：" + serverPort);
        }else {
            return new CommonResult(500, "插入数据失败");
        }

    }

    @GetMapping("/payment/get/{id}")
    public @ResponseBody CommonResult getPaymentById(@PathVariable("id") Long id) {
        System.out.println("/payment/get/{id}");
        Payment result = paymentService.getPaymentById(id);

        log.info("====== 查询结果：" + result);
        if(result != null) {
            CommonResult commonResult = new CommonResult(200, "查询成功，服务端口：" + serverPort, result);
            return commonResult;
        }else {
            return new CommonResult(500, "查询失败");
        }

    }
}
