package com.cmbc.day11.demo05;

import com.cmbc.day11.red.RedPacketFrame;

public class BootStrap {
    public static  void main(String[] args) {
        Red red = new Red("来自Inspur的红包");
//        red.setOpenWay(new OpAvg());
        red.setOpenWay(new Opway());
        red.setOwnerName("张三");
    }
}
