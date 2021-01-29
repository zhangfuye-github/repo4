package com.itheima.proxyclass;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;


/**
 * @Auther: 张夫业
 * @Date: 2020/11/16
 * @Description:
 */
public class Client {
    public static void main(final String[] args) {
        final Producer producer = new Producer();
        Producer cglibproducer =(Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName());
                System.out.println(args[0]);
                Float a=(Float)args[0];
                Object o = method.invoke(producer, a * 0.1f);
                return o;
            }
        });
        cglibproducer.saleProducot(10000f);
    }
}
