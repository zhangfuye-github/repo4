package com.cmbc.demo03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串字符串：");
        String s = sc.next();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            if (hashMap.containsKey(c)) {
                Integer i = hashMap.get(c);
                i++;
                hashMap.put(c,i);
            }else{
                hashMap.put(c,1);
            }
        }
        System.out.println(hashMap);
        Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            System.out.println(entry);
        }
        Set<Character> keySet = hashMap.keySet();
        for (Character c : keySet) {
            System.out.println(c+"=="+hashMap.get(c));

        }
    }
}
