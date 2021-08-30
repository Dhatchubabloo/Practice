package com.zoho.l2_programs;

import java.util.Scanner;

public class NumberPattern {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number");
        int number = scan.nextInt();
        int row = number;
        int col = number;
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if(i==0||i==row-1||j==0||j==col-1){
                    System.out.print(number);
                }
                else if(i==1||i==row-2||j==1||j==col-2){
                    System.out.print(number-1);
                }
                else
                    System.out.print(number-2);
            }
            System.out.println();
        }
    }
}
