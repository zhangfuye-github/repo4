package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/25
 * @Description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        final Lenovo lenovo = new Lenovo();
        /**
         * 增强对象的方式：
         *      1.代理模式
         *          1.静态代理
         *          2.动态代理
         *              两者的区别：是否在过程中生成类文件
         *      2.装饰着模式
         *
         */
        //代理模式，就要用到类proxy,通过代理增强对象
        SaleComputer proxyLev = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
/*                System.out.println("代理对象被执行了。。。。。");
                System.out.println(method.getName());
                System.out.println(args[0]);
                return null;*/
                double money = (double)args[0];
                money = money * 0.85;
                System.out.println("专车接你....");
                //使用真实对象调用该方法
                String obj = (String) method.invoke(lenovo, money);
                System.out.println("免费送货...");
                //2.增强返回值
                return obj+"_鼠标垫";
            }
        });
        String s = proxyLev.sale(8000);
        System.out.println(s);
/*        String sale = lenovo.sale(8000);
        lenovo.show();
        System.out.println(sale);*/
    }
}
