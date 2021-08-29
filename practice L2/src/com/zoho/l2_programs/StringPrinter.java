package com.zoho.l2_programs;

import java.util.Scanner;
public class StringPrinter {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        for(int i=1;i<word.length();i+=2){
            int val = word.charAt(i);
            if(val>=48&&val<=57&&i<word.length()-1) {
                int num = word.charAt(i + 1);
                if (num >= 48 && num <= 57) {
                    int x = val - 48;
                    int y = num - 48;
                    int z = (x * 10) + y;
                    for(int j=0;j<z;j++){
                        System.out.print(word.charAt(i-1)+" ");
                    }
                    i++;
                }
                else{
                    int value = val-48;
                    for(int k=0;k<value;k++){
                        System.out.print(word.charAt(i-1)+" ");
                    }
                }
            }
            else{
                int num1 = val-48;
                for(int h=0;h<num1;h++){
                    System.out.print(word.charAt(i-1)+" ");
                }
            }
        }
    }
}
