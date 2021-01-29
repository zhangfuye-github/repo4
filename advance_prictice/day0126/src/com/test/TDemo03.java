package com.test;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/26
 * @Description:
 */
public class TDemo03 {
    public static void main(String[] args) {
        String s = new StringBuilder("计算机").append("软件").toString();//jdk1.6使用StringBuilder创建的对象在堆中，intern()方法会复制一份到常量池中
//        System.out.println(s.intern()==s);
//        System.out.println(s.getBytes());
        System.out.println(s.intern().getBytes());
        String s1 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s1.getBytes());
//        System.out.println(s1.intern().getBytes());
        System.out.println(s1.intern()==s1);
    }
}
