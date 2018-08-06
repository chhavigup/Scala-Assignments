package com.knoldus;
import java.util.*;

import static java.util.stream.Collectors.toList;


public class Ques1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            int e = rand.nextInt(100);
            list.add(e);
        }
            System.out.println(list.stream()
                    .filter(num ->isPrime(num))
                    .collect(toList()));

    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
