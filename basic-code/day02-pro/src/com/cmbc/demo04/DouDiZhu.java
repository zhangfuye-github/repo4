package com.cmbc.demo04;

import java.util.ArrayList;
import java.util.Collections;

public class DouDiZhu {
    public static void main(String[] args) {
        String[] arr={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] arr1={"♥","♣","♠","♦"};
        ArrayList<String> list = new ArrayList<>();
        String s;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                s=arr[i]+arr1[j];
                list.add(s);
            }
        }
        list.add("大王");
        list.add("小王");
//        System.out.println(list);
        Collections.shuffle(list);
//        System.out.println(list);
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> battle = new ArrayList<>();
        for (int i = list.size()-3; i < list.size(); i++) {
            battle.add(list.get(i));
        }
        for (int i = 0; i < list.size()-3; i++) {
            if(i%3==0){
                player1.add(list.get(i));
            }else if (i%3==1){
                player2.add(list.get(i));
            }else{
                player3.add(list.get(i));
            }
        }
//        Collections.sort(player1);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(battle);
    }
}
