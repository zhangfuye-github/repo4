package cn.com.cmbc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:
 */
@RestController
public class ConController {
    @Value("${name}")//此处用到spring的el表达式
    private String name;

    @Value("${person.name}")//此处用到spring的el表达式
    private String name1;
    @Value("${product.addr}")//此处用到spring的el表达式
    private String addr;
    @RequestMapping("/confingration")
    public String demo(){
        return "name:"+"<br>"+name+"<br>"
                +"person.name:"+"<br>"+name1+"<br>"
                +"prodct.addr:"+"<br>"+addr;
    }
}
