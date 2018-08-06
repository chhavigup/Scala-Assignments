package com.knoldus;

import java.util.*;


import java.util.HashMap;
import java.util.Scanner;

    public class Ques2 {

        private static HashMap<String, Integer> uniqueList(String in) {
            HashMap<String, Integer> map=new HashMap<>();

            String [] spilit=in.split(" ");

            for(int i=0;i<spilit.length;i++) {
                if(map.containsKey(spilit[i])) {
                    map.put(spilit[i],map.get(spilit[i]) +1);}
                else
                    map.put(spilit[i], 1);

            }
            return map;
        }
        public static void main(String[] args) {

            Scanner scan=new Scanner(System.in);
            String in=scan.nextLine();
            HashMap<String,Integer> map=uniqueList(in);
            System.out.println(map);
        }

    }

