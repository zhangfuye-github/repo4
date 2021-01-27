package com.cmbc.day08.demo04;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/1
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {

        String s = new String("abcdefg");
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 += s.charAt(s.length() - 1 - i);

        }
        System.out.println(s1);
    }
}
