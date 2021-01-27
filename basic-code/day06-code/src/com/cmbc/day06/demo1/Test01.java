package com.cmbc.day06.demo1;

/**
 * @Auther: 张夫业
 * @Date: 2020/12/1
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {
        int temp;
        int[] arr={1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < (arr.length)/2; i++) {
            temp=arr[arr.length-1-i];
            arr[arr.length-1-i]=arr[i];
            arr[i]=temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
