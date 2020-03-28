package com.cmbc.day09.demo3;
/*
该案例用来测试方法是否可以改变变量，就是go中的值传递和地址传递
 */
public class Method1 {
    public static void main(String[] args) {
        int a=100;
        method(a);
        System.out.println(a);//该方法表示java中的参数传递都是值传递。那么java中如何实现改变值呢、
    }

    private static int method(int a) {
        a=10;
        return a;

    }
}
