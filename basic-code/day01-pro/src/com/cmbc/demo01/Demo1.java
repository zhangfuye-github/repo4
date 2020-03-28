package com.cmbc.demo01;

import java.util.Objects;

public class Demo1 {
    public static void main(String[] args) {
        Person s =new Person();
        s.setName("张三");
        s.setAge(18);
        Person s1=new Person("张三",18);
        System.out.println(Objects.toString(s, "s.getName()+s.getAge()"));
        System.out.println(s.hashCode());//返回的是十进制
        System.out.println("==============================");
        System.out.println(s1);
        System.out.println(s1.hashCode());//返回的是十进制
        System.out.println("==============================");
        System.out.println(s1.getClass());
        System.out.println(s.equals(s1));
        String ss="123";
        String s2="123";
        ss.equals(s2);
    }
}
