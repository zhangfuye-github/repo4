package com.cmbc.day08.demo2;
/*
字符串的分割方法split
 */
public class StringSplit {
    public static void main(String[] args) {
        String a="aaa,d,v,b,fh,ds,ffff";
        String[] split = a.split(",");
        System.out.println(split);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        String b="123.456.7.8.9.043.467.7898";
        String[] strings = b.split("\\.");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
