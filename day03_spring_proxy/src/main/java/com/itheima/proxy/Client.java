package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: 张夫业
 * @Date: 2020/11/16
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        final Product producer=new Producer();
        Product p=(Product) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName());
                        System.out.println(args[0]);
                        Float a=(Float)args[0];
                        Object o = method.invoke(producer, a * 0.1f);
                        return o;
                    }
                });
        p.saleProducot(10000.0f);
    }
}
