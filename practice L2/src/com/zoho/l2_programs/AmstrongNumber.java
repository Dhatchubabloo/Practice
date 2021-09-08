package com.zoho.l2_programs;

import java.util.Scanner;

public class AmstrongNumber {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int number  = scan.nextInt();
        int temp=number;
        int sum=0;
        while(temp>0){
            int rem = temp%10;
            sum+=Math.pow(rem,3);
            temp=temp/10;
        }
        if(sum==number){
            System.out.println("Amstrong number");
        }
        else
            System.out.println("not Amstrong number");
    }
}
