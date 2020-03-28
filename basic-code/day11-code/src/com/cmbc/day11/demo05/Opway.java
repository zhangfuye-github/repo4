package com.cmbc.day11.demo05;

import com.cmbc.day11.red.OpenMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Opway implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < totalCount-1; i++) {
            Random random = new Random();
            int anInt = random.nextInt(totalMoney / 2)+1;
            totalMoney=totalMoney-anInt;
            list.add(anInt);
        }
        list.add(totalMoney);
        return list;
    }
}
