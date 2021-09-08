package com.zoho.l2_programs;

import java.util.Scanner;

public class CharSorting {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        char array[] = word.toCharArray();
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    char tem =array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                }
            }
        }
        String result = new String(array);
        System.out.println(result);
    }
}
