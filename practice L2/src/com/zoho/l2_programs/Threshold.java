package com.zoho.l2_programs;

import java.util.Scanner;

public class Threshold {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size");
        int size = scan.nextInt();
        System.out.println("Enter elements");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        System.out.println("Enter threshold");
        int threshold = scan.nextInt();
        int count = 0;
        for(int i=0;i<size;i++) {
            int temp=threshold;
            while (temp > 0) {
                if (array[i] >= temp) {
                    array[i] = array[i] - temp;
                    count++;
                } else
                    temp--;
                if (array[i] == 0) {
                    break;
                }
            }
        }
        System.out.println("Total count is : "+count);
    }
}
