package com.knoldus;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Ques4 {
    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(2,4,6,8,9);

        List listOfProduct =list1.stream()
                .flatMap( s1 -> list2.stream().map( s2 -> s1 * s2 ) )
                .collect( Collectors.toList() );
        System.out.println(listOfProduct);
        }

    }

