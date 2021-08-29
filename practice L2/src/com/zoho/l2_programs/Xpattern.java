package com.zoho.l2_programs;

import java.util.Scanner;
public class Xpattern {
    public static void main(String  [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the word");
        String word = scan.next();
        char arr[] = word.toCharArray();
        int len = arr.length;
        int k = len-1;
       for(int i=0;i<len;i++){
           for(int j=0;j<len;j++){
               if(j==i){
                   System.out.print(arr[i]);
               }
               else if(j==k){
                   System.out.print(arr[j]);
               }
               else
                   System.out.print(" ");
           }
           k--;
           System.out.println();
       }
    }
}
