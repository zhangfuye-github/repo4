package com.cmbc.demo03;

import java.util.ArrayList;
import java.util.Collection;

public class Demo03 {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("sss");
        Collection<Integer> list1=new ArrayList<>();
        list1.add(123);
        list1.add(456);
        list1.add(678);
        method( list);
        method(list1);
    }
    public static void method(Object list){//传入Object类
        System.out.println(list);
    }
    public static void method1(Collection<?> list){//传入泛型
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
