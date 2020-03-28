package com.cmbc.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        for(;;){
            System.out.println(sumDayBirth());
        }
    }
    public static long sumDayBirth() {
        System.out.println("请输入如下格式的生日：yyyy年MM月dd日");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(s);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
//        Date date1 = format.parse("1996年6月22日");
//        long time = date1.getTime();
        Date date1 = null;
        long time=0;
        try {
            date1 = format.parse(s);
            time = date1.getTime();
        } catch (ParseException e) {
            System.out.println("请输入正确的日期格式：");
        }
        long time1 = date.getTime();
        long numday=(long)(time1-time)/(long)(60*60*24*1000);
        return numday;
    }
}
