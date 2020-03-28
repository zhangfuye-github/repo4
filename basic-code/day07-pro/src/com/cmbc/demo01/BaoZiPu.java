package com.cmbc.demo01;

public class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count % 2 == 0) {
                    bz.setPi("薄皮");
                    bz.setXian("三鲜馅");
                } else {
                    bz.setPi("冰皮");
                    bz.setXian("牛肉馅");
                }
                System.out.println("正在生产" + bz.getPi() + bz.getXian() + "包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                bz.flag = true;
                bz.notify();
                System.out.println("已经生产好" + bz.getPi() + bz.getXian() + "包子");
            }
        }
    }
}
