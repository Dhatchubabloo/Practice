package com.zoho.l2_programs;

import java.util.ArrayList;

public class SumArray {
  static ArrayList list = new ArrayList();
    public static void main(String[]args){
        int array[] = {3,6,4,8,9};
        new SumArray().sum(0,array);
        System.out.println(list);
    }
     void sum(int point,int[]array){
        if(point< array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                if (i != point) {
                    sum += array[i];
                }
            }
            list.add(sum);
            sum(++point, array);
        }

    }
}
