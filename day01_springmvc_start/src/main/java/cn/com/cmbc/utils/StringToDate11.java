package cn.com.cmbc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/20
 * @Description:
 */
public class StringToDate11 implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source==null){
            throw new RuntimeException("请输入日期");
        }
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("日期格式不正确");
        }
        return date;
    }
}
