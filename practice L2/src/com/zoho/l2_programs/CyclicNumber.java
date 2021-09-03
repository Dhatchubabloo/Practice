package com.zoho.l2_programs;

import java.util.Scanner;

public class CyclicNumber {
    public static void  main(String []args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int temp = number;
        int count=0;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        int array[] = new int[count];
        for(int i=1;i<=count;i++){

        }
    }
}
