package com.cmbc.demo01;

public class ChiHuo extends Thread{
    private BaoZi bz;

    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }
    @Override
    public void run() {
        while(true){
            synchronized (bz){
                if (bz.flag==false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("正在吃"+bz.getPi()+bz.getXian()+"包子");
                bz.flag=false;
                bz.notify();
                System.out.println("已经吃完"+bz.getPi()+bz.getXian()+"包子");
                System.out.println("----------------------------------------");
            }
        }

    }
}
