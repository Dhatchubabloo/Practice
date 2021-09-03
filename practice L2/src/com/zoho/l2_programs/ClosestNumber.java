package com.zoho.l2_programs;

import java.util.Scanner;

public class ClosestNumber {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        int num1=0,num2=0;
        int diff = Math.abs(array[0]-array[1]);
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++) {
                int diff1 = Math.abs(array[i] - array[j]);
                if (diff1 <= diff) {
                    diff=diff1;
                    num1 = array[i];
                    num2 = array[j];
                }
            }
        }
        System.out.println("The closest Numbers are : "+num1+","+num2);
        }
    }

