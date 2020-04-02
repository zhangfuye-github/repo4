package com.cmbc.day13.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/1
 * @Description:
 */
public class StreamFirst {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);
        new Thread(() -> list.stream()
                .filter(s -> s.length()==3)
                .filter(s -> s.contains("张"))
                .forEach(s -> System.out.println(s))).start();
/*        list.stream()
                .filter(s -> s.length()==3)
                .filter(s -> s.contains("张"))
                .forEach(s -> System.out.println(s));*/

        ListAccess(list);

    }

    public static void ListAccess(List<String> list) throws InterruptedException {
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (s.length()==3) {
                list1.add(s);
            }
        }
        System.out.println(list1);
        List<String> list2 = new ArrayList<>();
        for (String s : list1) {
            if (s.contains("张")) {
                list2.add(s);
            }
        }
        Thread.sleep(1000);
        System.out.println(list2);

    }
}
