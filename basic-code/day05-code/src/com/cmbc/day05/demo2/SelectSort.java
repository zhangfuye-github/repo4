package com.cmbc.day05.demo2;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 9, 3, 10, 5, 7, 8, 0};
        System.out.println("数组翻转前：");
        train(array);
        int[] ints1 = selectSort(array);
        train(ints1);
    }

    public static int[] selectSort(int[] array) {
        int max = 0;
        int temp;
        int i;
        for (i = 0; i < array.length; i++) {
            max=i;
            for (int j = i+1; j <array.length ; j++) {
                if (array[j] < array[max]) {
                    max = j ;
                }
            }
            temp = array[max];
            array[max] = array[i];
            array[i] = temp;
            System.out.printf("第%d次排序后：",i+1);
            train(array);
        }
        return array;
    }

    public static void train(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("   " + array[i]);
        }
        System.out.println();
    }
}
