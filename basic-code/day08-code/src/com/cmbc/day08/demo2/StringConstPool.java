package com.cmbc.day08.demo2;
/*
本案例主要讲解字符串常量池
字符串的创建有三种方式：
    1.直接赋值一个双引号引起来的内容：String a="abc"
    2.String a=new String(char[] array);
    3.String a=new String(byte[] array);
其实字符串可以看做是一个字符数组，其本质是一个字节数组，
在java当中，堆中存在一个字符串常量池，以直接赋值方式定义的字符串，都在常量池当中，
==比较运算符，在java当中，引用类型进行比较时比较的是地址值，而基本类型比较的是数值。
字符串不管有没有new都是String类的实例。
 */
public class StringConstPool {
    public static void main(String[] args) {
        String s = new String();
        s="abc";
        String a="abc";
        String b="abc";
        char[] arr={'a','b','c'};
        byte[] arr2={97,98,99};
        String c=new String(arr);
        String d=new String(arr2);
        System.out.println(a==b);//true
        System.out.println(a==c);//false
        System.out.println(a==d);//false
    }
}
