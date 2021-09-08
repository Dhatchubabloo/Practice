package com.zoho.l2_programs;

import java.util.Scanner;

public class CombinationOf3And4 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        for(int i=1;i<number;i++){
            int count=0,charCount=0;
            int temp=i;
            while(temp>0) {
                int rem = temp % 10;
                charCount++;
                if (rem == 3 || rem == 4) {
                    count++;
                }
                temp=temp/10;
            }
            if(count==charCount){
                System.out.println(i);
            }
        }

    }
}
