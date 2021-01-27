package cn.com.cmbc;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/30
 * @Description:
 */
public class Test04 {
    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);
        Random r=new Random();
        double doubles = r.nextDouble();
        System.out.println(doubles);
        int[] arr=new int[5];
        System.out.println(arr);
        Date date = new Date();

        System.out.println(date);
    }
}
