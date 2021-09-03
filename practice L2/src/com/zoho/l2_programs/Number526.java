package com.zoho.l2_programs;

import java.util.Scanner;

public class Number526 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int totalCount=0;
        for(int i=0;i<number;i++){
            int temp=i;
            int count=0;
            int charCount=0;
            while(temp>0){
                charCount++;
                int rem =temp%10;
                if(rem==0){
                    count++;
                }else if(rem==5){
                    count++;
                }else if(rem==6){
                    count++;
                }else
                    break;
                temp=temp/10;
            }
            if(count==charCount){
                totalCount++;
                System.out.println(i);
            }
        }
        System.out.println("The total count is: "+totalCount);
    }
}