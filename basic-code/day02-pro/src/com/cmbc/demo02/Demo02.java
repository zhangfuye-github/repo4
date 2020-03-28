package com.cmbc.demo02;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Object> obj = new ArrayList<>();
        obj.add("1243");
        obj.add(1);
        Iterator<Object> it = obj.iterator();
        Object o;
        while(it.hasNext()){
            o = it.next();
            System.out.println(o);
//            String s = String.valueOf(o);
// 如果不使用泛型，可以通过字符串类型和基本类型的相互转换String.valueOf
            String s=(String)(o);//强制类型转换，会出现类型转换异常。
            System.out.println(s.length());

        }
    }
}
