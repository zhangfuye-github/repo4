package com.cmbc.day05.demo1;
/*
* 体验ideafor循环的强大之处。
* */
public class ArrayTrain {
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5,6,7,8};
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        for (int i = array1.length - 1; i >= 0; i--) {
            System.out.println(array1[i]);
        }
        for (int i : array1) {//foreach 循环当中，i是从1 开始。idea中存在三种循环遍历方式，
            //变量.fori,变量.forr,变量for.
            System.out.println(array1[i-1]);
        }
    }
}
