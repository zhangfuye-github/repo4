package com.cmbc.day09.demo4;

/*
写一个方法：对比两个值是否相同。
 */
public class MethodSame {
    public static void main(String[] args) {
        String a="zahngfuye";
        String b="zahng";

        System.out.println(method(a,b));
    }

    public static boolean method(Object a, Object b){
        return a==b;
    }
}
