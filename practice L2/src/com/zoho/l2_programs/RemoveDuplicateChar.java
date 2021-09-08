package com.zoho.l2_programs;

import java.util.Scanner;

public class RemoveDuplicateChar {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        char array[] = word.toCharArray();
        int len= array.length;
        char temp[] = new char[123];
        for(int i=0;i<123;i++){
            temp[i]=0;
        }
        for(int i=0;i<len;i++){
            int value = array[i];
            temp[value]++;
        }
        for(int i=0;i<len;i++){
           int val = array[i];
           if(temp[val]>0){
               System.out.print((char)val);
               temp[val]=0;
           }
        }
    }
}
