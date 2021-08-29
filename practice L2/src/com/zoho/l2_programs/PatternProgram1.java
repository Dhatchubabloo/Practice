package com.zoho.l2_programs;

import java.util.Scanner;

public class PatternProgram1 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter row");
        int row = scan.nextInt();
        System.out.println("Enter column");
        int col = scan.nextInt();
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if(i==0||i==row-1||j==0||j==col-1){
                    System.out.print("x ");
                }
                else if(i==1||i==row-2||j==1||j==col-2){
                    System.out.print("o ");
                }
                else
                    System.out.print("x ");
            }
            System.out.println();
        }
    }
}

