package com.zoho.l2_programs;

import java.util.Scanner;

public class PyramidOfNumbers {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
