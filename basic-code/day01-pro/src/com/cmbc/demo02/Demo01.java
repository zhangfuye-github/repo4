package com.cmbc.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String s = simpleDateFormat.format(date);
        Date date1 = simpleDateFormat.parse("2000年12月09日");
        System.out.println(date1);
        System.out.println(s);
//        System.out.println(date.getTime());
//        System.out.println(System.currentTimeMillis());
    }
}
