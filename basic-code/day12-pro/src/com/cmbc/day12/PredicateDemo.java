package com.cmbc.day12;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:数组当中有多条“姓名+性别”的信息如下，请通过Predicate 接口的拼装将符合要求的字符串筛选到集合
 * ArrayList 中，需要同时满足两个条件：
 * 1. 必须为女生；
 * 2. 姓名为4个字。
 * public class DemoPredicate {
 * public static void main(String[] args) {
 * String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
 * }
 * }
 */
public class PredicateDemo {
    public static void method(String[] array, Predicate<String> pre,Predicate<String> pre1){
        ArrayList<String> list=new ArrayList<>();
        for (String s : array) {
            boolean b = pre.and(pre1).test(s);
            if (b){
                list.add(s);
            }
        }
        System.out.println(list.toString());
    }
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        method(array,(String s)->{
                    String[] split = s.split(",");
                    String s1 = split[0];
                    return s1.length()==4;
                },
                (String s)->{
                    String[] split = s.split(",");
                    String s1 = split[1];
                    return "女".equals(s1);
                });
    }
}
