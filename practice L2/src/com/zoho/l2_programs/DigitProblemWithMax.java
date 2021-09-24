package com.zoho.l2_programs;

import java.util.Scanner;

// int a = 2678906
//int d = 6    78906   max value among this is:9
public class DigitProblemWithMax {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        long value= scan.nextLong();
        int target = scan.nextInt();
        int max=0;
        String number = String.valueOf(value);
        for(int i=0;i<number.length();i++){
            int a  =number.charAt(i)-48;
            if(a==target){
                max = number.charAt(i+1);
                while(i<number.length()-1) {
                   if(number.charAt(i+1)>max){
                       max = number.charAt(i+1)-48;
                   }
                    i++;
                }
            }
        }
        System.out.println(max);
    }
}
