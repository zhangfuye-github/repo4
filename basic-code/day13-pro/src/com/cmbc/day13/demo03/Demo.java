package com.cmbc.day13.demo03;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/2
 * @Description:
 */
public class Demo {
    public static int[] method(int a, ArrayBuilder arrayBuilder) {
        return arrayBuilder.creatArray(a);
    }

    public static void main(String[] args) {
        int[] ints = method(100, length -> new int[length]);
        System.out.println(ints.length);
        System.out.println("######################################");
        int[] method1 = method(50, int[]::new);
        System.out.println(method1.length);
    }
}
