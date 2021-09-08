package com.zoho.l2_programs;

import java.util.Scanner;

public class ArrayOfIntegers {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1st Number");
        int size = scan.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Enter 2nd Number");
        int size1 = scan.nextInt();
        int array1[] = new int[size1];
        for (int i = 0; i < size1; i++) {
            array1[i] = scan.nextInt();
        }
        long value = 0;
        for(int i=0;i< array.length;i++){
            value = (value*10)+array[i];
        }
        long value1 = 0;
        for(int i=0;i< array1.length;i++){
            value1 = (value1*10)+array1[i];
        }
        long result = value+value1;
        String word = String.valueOf(result);
        int len = word.length();
        int resultArray[] = new int[len];
        for(int i=0;i<len;i++){
            resultArray[i] = word.charAt(i)-48;
        }
        System.out.println("The resultant Array Was:");
        for(int i=0;i<len;i++){
            System.out.print(resultArray[i]+" ");
        }
    }
}
