package com.cmbc.day07.demo1;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        for (int j = 0; j < 10; j++) {
            System.out.println("请输入你猜的数：");
            int i1 = scanner.nextInt();
            if(i1>i){
                System.out.println("你猜的大了，请重新输入！");
            }else if(i1<i){
                System.out.println("你猜的小了，请重新输入！");
            }else{
                System.out.println("恭喜你，猜对了！");
                break;
            }
            if(j==9) {
                System.out.println("你的猜测次数已经用完！");
            }
        }
    }
}
