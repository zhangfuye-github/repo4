package com.cmbc.demo02;

public class SumRecursion {
    public static void main(String[] args) {
        int sum = sum(100);
        System.out.println(sum);
        sum1(100);
    }

    private static void sum1(int n) {
        int su=0;
        for (int i = 0; i <= n; i++) {
            su+=i;
        }
        System.out.println(su);
    }

    private static int  sum(int n) {
        if(n==0){
            return n;
        }
        return n+sum(n-1);

    }

}
