package cn.com.cmbc.controller;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/2
 * @Description:
 */
public class StringToDateConvert implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        return null;
    }
}
