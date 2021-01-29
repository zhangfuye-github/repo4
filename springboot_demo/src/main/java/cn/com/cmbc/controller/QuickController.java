package cn.com.cmbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@RestController
public class QuickController {
    @RequestMapping("quick")
    public String demo(){
        return "你好，springboot";
    }
}
