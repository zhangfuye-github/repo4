package com.itheima.proxy;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/16
 * @Description:
 */
public class Producer implements Product{
    public void saleProducot(float f){
        System.out.println("电脑售价："+f);

    }
    public void afterSale(float f){
        System.out.println("电脑修好了，收费"+f);
    }

}
