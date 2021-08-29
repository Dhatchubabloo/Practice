package com.zoho.l2_programs;

import java.util.Scanner;

public class DuplicateNumbers {
    public static void main(String  [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array Size");
        int size = scan.nextInt();
        System.out.println("Enter the Elements");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        System.out.println("the duplicate Numbers Are:");
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(array[i]==array[j])
                    System.out.println(array[i]);
            }
        }
    }
}
