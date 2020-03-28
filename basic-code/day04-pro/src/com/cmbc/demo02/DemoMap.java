package com.cmbc.demo02;

import java.util.HashMap;
import java.util.Map;

public class DemoMap {
    public static void main(String[] args) {
        Map<String,Person> map=new HashMap<>();
        Person p=new Person();
        p.setAge(14);
        p.setName("张三");
        map.put("1",p);
        System.out.println(map);

    }
}
