package com.zoho.l2_programs;

import java.util.Scanner;

public class MinimizeASCIIValues {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String word  =scan.next();
        int len = word.length();
        char temp = word.charAt(0);
        int val=0;
        for(int i=0;i<len;i++){
            int count=0;
            while(temp==word.charAt(i)){
                count++;
                if(i<len-1)
                    i++;
                else{
                    val++;
                    break;
                }
            }
        }
    }
}
