package com.cmbc.day12;

import java.util.function.Supplier;

/**
 * @Auther: 张夫业
 * @Date: 2020/3/31
 * @Description:
 */
public class FunctionInterfaceMax {
    public static Integer getMax(Supplier<Integer> supplier){
        return supplier.get();
    }
    public static void main(String[] args) {
        int[] arr={1,5,0,4,8,17,88,33};
        Integer max1 = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(max1);
    }

}
