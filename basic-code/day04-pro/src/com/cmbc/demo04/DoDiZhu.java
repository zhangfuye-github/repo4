package com.cmbc.demo04;

import java.util.*;

public class DoDiZhu {
    public static void main(String[] args) {
        String[] arr={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        String[] arr1={"♥","♣","♠","♦"};
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        String s;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                s=arr[i]+arr1[j];
                map.put(4*i+j,s);
                list.add(4*i+j);
            }
        }
        map.put(52,"大王");
        map.put(53,"小王");
        list.add(52);
        list.add(53);
        Set<Integer> set = map.keySet();
//        System.out.println(set);
//        System.out.println(list);
        Collections.shuffle(list);
//        System.out.println(list);
        LinkedHashMap<Integer, String>  player1 = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> player2 = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> player3 = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> battle = new LinkedHashMap<>();
        for (int i = list.size()-3; i < list.size(); i++) {
            battle.put(list.get(i),map.get(list.get(i)));
            list4.add(list.get(i));
        }
        for (int i = 0; i < list.size()-3; i++) {
            if(i%3==0){
                player1.put(list.get(i),map.get(list.get(i)));
                list1.add(list.get(i));
            }else if (i%3==1){
                player2.put(list.get(i),map.get(list.get(i)));
                list2.add(list.get(i));
            }else{
                player3.put(list.get(i),map.get(list.get(i)));
                list3.add(list.get(i));
            }
        }
        sortMethod(list1, player1);

        sortMethod(list2, player2);

        sortMethod(list3, player3);

        sortMethod(list4, battle);
    }

    private static void sortMethod(List<Integer> list1, LinkedHashMap<Integer, String> player1) {
        System.out.println(player1);
        Collections.sort(list1);
        for (Integer integer : list1) {
            System.out.print(player1.get(integer) + ",    ");
        }
        System.out.println();
    }
}
