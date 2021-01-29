package cn.com.cmbc.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/25
 * @Description:RestController是responsebody和ruquestmapping的整合
 */
@RestController
@ConfigurationProperties(prefix = "phone")
public class Quick3Controller {
    private String name;
    private Integer price;
    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @RequestMapping("quick3")
    public String demo() {
        return "phone.name:" + "<br>" + name + "<br>"
                + "phone.price:" + "<br>" + price + "<br>"
                + "phone.time:" + "<br>" + time;
    }
}
