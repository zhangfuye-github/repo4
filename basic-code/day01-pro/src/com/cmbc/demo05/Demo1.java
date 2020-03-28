package com.cmbc.demo05;

public class Demo1 {
    public static void main(String[] args) {
        String s="123";
        int i = Integer.parseInt(s);
        System.out.println(i);
        String s1 = Integer.valueOf(i).toString();
        System.out.println(s1.getClass());
        String s2 = Integer.toString(12);
        System.out.println(s2.getClass());
    }
}
