package com.cmbc.day05.demo2;

public class ArrayMax {
    /*
    * 用来求数组的最大值
    * */
    public static void main(String[] args) {
        //数组的定义方式
        int[] array={1,5,9,3,10,5,7,8,0};
        int[] arr1=new int[8];
        int[] arr2=new int[]{};
        int i = maxArray(array);
//        System.out.println("max:"+i);
        System.out.println("数组翻转前：");
        train(array);
//        int[] ints = reverse(array);
//        System.out.println("数组翻转后：");
//        train(ints);
        /*数组排序*/
        int[] ints1 = bubbleSort(array);
        train(ints1);
    }
    public static int[] bubbleSort(int[] array){
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            System.out.printf("第%d次遍历后：\n",i+1);
            train(array);
        }
        return array;
    }
    /*求数组中元素最大值*/
    public static int maxArray(int[] array){
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    /*遍历数组*/
    public static void train(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print("   "+array[i]);
        }
        System.out.println();
    }
    /*数组翻转*/
    public static int[] reverse(int[] array){
        int temp;
        for (int i = 0; i < (array.length)/2; i++) {
            temp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
        return array;
    }

}
