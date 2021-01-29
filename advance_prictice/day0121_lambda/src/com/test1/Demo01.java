package com.test1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalField;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/21
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime=LocalDateTime.now();
//        System.out.println(localDateTime);
        int hour = localDateTime.getHour();
//        System.out.println(hour);
        Month month = localDateTime.getMonth();//月份的英文
        System.out.println(month);
        int monthValue = localDateTime.getMonthValue();//月份的数值
        System.out.println(monthValue);
        System.out.println(localDateTime.getDayOfWeek());//周几
//        System.out.println(localDateTime.getChronology());

        Instant ins = Instant.now();
        System.out.println(ins);
    }
}
