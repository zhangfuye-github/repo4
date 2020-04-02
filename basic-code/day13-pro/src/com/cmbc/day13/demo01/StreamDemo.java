package com.cmbc.day13.demo01;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/1
 * @Description:现在有两个ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以
 * 下若干操作步骤：
 * 1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
 * 2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
 * 3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
 * 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
 * 5. 将两个队伍合并为一个队伍；存储到一个新集合中。
 * 6. 根据姓名创建Person 对象；存储到一个新集合中。
 * 7. 打印整个队伍的Person对象信息。
 */
public class StreamDemo {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        //  1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
//        OldMethod(one, two);
        // 1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        NewMethod(one, two);
        // 6. 根据姓名创建Person 对象；存储到一个新集合中。
        // 7. 打印整个队伍的Person对象信息。

    }

    public static void NewMethod(ArrayList<String> one, ArrayList<String> two) {
        Stream<String> limit = one.stream().filter(s -> s.length() == 3).limit(3);
        // 2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        // 3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        Stream<String> skip = two.stream().filter(s -> s.contains("张")).skip(2);
        // 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        // 5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        Stream<Person> personStream = Stream.concat(limit, skip).map(s -> new Person(s));
        personStream.forEach(s -> System.out.println(s));
    }

    public static void OldMethod(ArrayList<String> one, ArrayList<String> two) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        ArrayList<Person> list5 = new ArrayList<>();
        for (String s : one) {
            if (s.length() == 3) {
                list1.add(s);
            }
        }
        System.out.println("******************************************");
        System.out.println("list1:" + list1);
        //  2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        for (int i = 0; i < 3; i++) {
            list2.add(list1.get(i));
        }
        System.out.println("******************************************");
        System.out.println("list2:" + list2);
        //  3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        for (String s : two) {
            if (s.contains("张")) {
                list3.add(s);
            }
        }
        System.out.println("******************************************");
        System.out.println("list3:" + list3);
        //  4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        for (int i = 2; i < list3.size(); i++) {
            list4.add(list3.get(i));
        }
        System.out.println("******************************************");
        System.out.println("list4:" + list4);
        System.out.println("******************************************");
        //  5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        for (String s : list4) {
            list2.add(s);
        }
        for (String s : list2) {
            System.out.println("组合list:" + s);
        }
        System.out.println("******************************************");
        System.out.println("list2:" + list2);
        System.out.println("******************************************");
        //  6. 根据姓名创建Person 对象；存储到一个新集合中。
        for (String s : list2) {
            list5.add(new Person(s));
        }
        System.out.println("list5:" + list5);
        //  7. 打印整个队伍的Person对象信息。
        System.out.println("******************************************");
        for (Person person4 : list5) {
            System.out.println(person4);
        }
    }
}