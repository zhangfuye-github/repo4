package com.cmbc.demo01;

import java.util.HashSet;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
        HashSet<String> hs;
        hs = new HashSet<>();
        hs.add("123");
        hs.add("456");
        hs.add("234");
        hs.add("123");
        System.out.println(hs);
        System.out.println(hs.size());
        for (String h : hs) {
            System.out.println(h);
        }
        Iterator<String> iterator = hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
