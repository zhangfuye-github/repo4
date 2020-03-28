package com.cmbc.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵柳");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("***********************************");
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        System.out.println("***********************************");
        Iterator<String> iterator = list.iterator();
        for (;iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println("***********************************");
        //被定义的迭代器对象只能使用一次。
        Iterator<String> iterator1 = list.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
