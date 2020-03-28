package com.cmbc.day11.demo05;

import com.cmbc.day11.red.OpenMode;

import java.util.ArrayList;

public class OpAvg implements OpenMode {

    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < totalCount-1; i++) {
            list.add(totalMoney/totalCount);
        }
        list.add(totalMoney/totalCount+totalMoney%totalCount);
        return list;
    }
}
