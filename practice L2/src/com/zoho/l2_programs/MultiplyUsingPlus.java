package com.zoho.l2_programs;

import java.util.Scanner;

public class MultiplyUsingPlus {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int result= 0;
        for(int i=0;i<num1;i++){
            result=result+num2;
        }
        System.out.println(result);
    }
}
