package cn.com.cmbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@RequestMapping("quick")
@RestController
public class QuickController {
    @RequestMapping("test")
    public String test(){
        return "你好,springboot!!!!";
    }
}
