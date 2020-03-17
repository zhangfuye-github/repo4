package com.cmbc.day08.demo2;


import java.util.ArrayList;

/*
本案列讲解String类的equals成员方法，用来进行字符串内容的比较。
调用该方法时建议用字符串常量.equal(字符串变量)，避免运行时出现空指针异常。
 */
public class StringEquals {
    public static void main(String[] args) {
        char[] arr=new char[]{'j','a','v','a'};
        int[] arr1=new int[]{1,2,3,4,56,6,7,9};
        System.out.println(arr);
        System.out.println(arr1);
        System.out.println("===============================");
//        int [] arrs=null;
//        System.out.println(arrs[1]);
       /*System.out.println(arr);
        String a="java";
        String b="java";
        String s = new String(arr);
        System.out.println("java".equals(a));//true
        System.out.println(b.equals(a));//true
        System.out.println(b.equals(s));//true
        System.out.println("java".equals(s));//true

        System.out.println("java".equals("Java"));//false
        System.out.println("java".equalsIgnoreCase("Java"));//true,该方法实现忽略英文字母大小写

        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);*/
    }
}
