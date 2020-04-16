package com.cmbc.day09.demo05;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/15
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        char cellphone=' ';
        float price=1166.56f;
        if (price>2000){
            cellphone='g';
        }else if(price>=1000){
            cellphone='j';
        }
        System.out.println(cellphone);
    }
}
