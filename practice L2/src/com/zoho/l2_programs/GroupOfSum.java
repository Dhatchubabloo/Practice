package com.zoho.l2_programs;

import java.util.Scanner;

public class GroupOfSum {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size");
        int size = scan.nextInt();
        System.out.println("Enter the elements");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        System.out.println("Enter the Number");
        int number = scan.nextInt();
        int count=0;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(array[i]%3==0&&array[j]%3==0) {
                    if ((array[i] + array[j]) % number == 0) {
                        System.out.println(array[i] + "," + array[j]);
                        count++;
                    }
                }
            }
        }
        System.out.println("Number of Groups"+count);
    }
}
