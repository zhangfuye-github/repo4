package com.cmbc.day12;

import java.util.function.Function;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:请使用Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * String str = "赵丽颖,20";
 * 1. 将字符串截取数字年龄部分，得到字符串；
 * 2. 将上一步的字符串转换成为int类型的数字；
 * 3. 将上一步的int数字累加100，得到结果int数字。
 */
public class FunctionDemo {
    public static void main(String[] args) {
        String str = "赵丽颖,20";
        method(str, str1 ->str1.split(",")[1],
                Integer::parseInt,
                 i -> i+100);
    }

    public static void method(String str, Function<String, String> fun1,
                              Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        Integer integer = fun1.andThen(fun2).andThen(fun3).apply(str);
        System.out.println(integer);
    }
}
