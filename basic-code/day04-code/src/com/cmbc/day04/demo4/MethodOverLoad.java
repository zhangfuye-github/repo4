package com.cmbc.day04.demo4;

public class MethodOverLoad {
    public static void main(String[] args) {
        //java中函数的重载就是函数名相同，但是参数列表个数不同，go中不支持方法的重载，但是可以
        //通过...传入多个参数
        sum(1,2,3,4,5,6,7,8,9);
        System.out.println();
    }

    public static void sum(int...arg){
        int sum =0;
        for (int i = 0; i <arg.length; i++) {
            sum=sum+arg[i];
        }
        System.out.println(sum);

    }
}
