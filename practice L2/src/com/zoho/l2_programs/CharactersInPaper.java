package com.zoho.l2_programs;

import java.util.Scanner;

public class CharactersInPaper {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number");
        int number = scan.nextInt();
        int count=0;
        for(int i=1;i<=number;i++){
            int temp =i;
            while(temp>0) {
                    count++;
                    temp=temp/10;
            }
        }
        System.out.println(count);
    }
}
