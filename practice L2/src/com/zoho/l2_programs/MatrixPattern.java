package com.zoho.l2_programs;

import java.util.Scanner;

public class MatrixPattern {
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number");
        int number= scan.nextInt();
        int index=number;
        for(int i=1;i<=number;i++){
            int value=i;
            int temp=number;
            for(int j=0;j<index;j++){
                if(i==1&&j==0||i==2&&j==0){
                    System.out.print("\t\t"+value+"\t\t");
                    value=value+temp;
                    temp--;
                }
                else {
                    System.out.print(value+"\t\t");
                    value = value + temp;
                    temp--;
                }
            }
            index--;
            System.out.println();
        }
    }
}
