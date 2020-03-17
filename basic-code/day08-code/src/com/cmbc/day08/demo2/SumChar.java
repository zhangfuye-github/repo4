package com.cmbc.day08.demo2;

import java.util.Scanner;

public class SumChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = scanner.nextLine();

        char[] chars = s.toCharArray();
        char a;
        int num1=0,num2=0,num3=0,num4=0,num5=0;
        for (int i = 0; i < chars.length; i++) {
            a=chars[i];
            if (a>='a'&&a<='z'){
                num1++;
            }else if(a>='A'&&a<='Z'){
                num2++;
            }else if(a==' '){
                num3++;
            }else if(a>='0'&&a<='9'){
                num4++;
            }else{
                num5++;
            }
        }
        System.out.println("小写字母个数是："+num1);
        System.out.println("大写写字母个数是："+num2);
        System.out.println("空格个数是："+num3);
        System.out.println("数字个数是："+num4);
        System.out.println("特殊字符个数是："+num5);
    }
}
