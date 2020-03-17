package com.cmbc.day05.demo2;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 9, 3, 10, 5, 7, 8, 0};
        System.out.println("数组翻转前：");
        train(array);
        int[] ints1 = insertSort(array);
        train(ints1);
    }

    public static int[] insertSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j>0; j--) {
                if(array[j]<array[j-1]){
                    temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
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
