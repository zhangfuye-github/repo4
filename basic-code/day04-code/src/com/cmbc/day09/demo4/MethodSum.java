package com.cmbc.day09.demo4;

import java.util.Scanner;

/*
求1-100的和
 */
public class MethodSum {
    public static void main(String[] args) {
        while (true){
            System.out.println("请输入一个数：");
            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();
            sumMeth(b);
            System.out.println(sumMeth(b));
        }
    }

    private static int sumMeth(int b) {
        int sum = 0;
        for (int i = 1; i <= b; i++) {
            sum+=i;
        }
        return sum;
    }
}
