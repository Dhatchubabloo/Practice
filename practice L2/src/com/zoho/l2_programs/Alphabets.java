package com.zoho.l2_programs;

import java.util.Scanner;

public class Alphabets {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int temp = number;
        String result ="";
        while(temp>0){
            int rem = temp%26;
            int value=0;
            if(rem>0) {
                value = 65 + (rem - 1);
                result += (char) value;
            }
            else {
                result += 'Z';
                temp--;
            }
            temp = temp / 26;
        }
        StringBuffer sb = new StringBuffer(result);
        System.out.println(sb.reverse());
    }
}