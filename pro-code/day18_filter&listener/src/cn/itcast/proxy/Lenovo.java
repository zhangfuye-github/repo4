package cn.itcast.proxy;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/25
 * @Description:
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double a) {
        System.out.println("这台电脑"+a+"元");

        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
