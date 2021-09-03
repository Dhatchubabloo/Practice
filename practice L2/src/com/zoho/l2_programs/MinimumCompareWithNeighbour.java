package com.zoho.l2_programs;

import java.util.Scanner;

public class MinimumCompareWithNeighbour {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int array[] = new int[size];
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        for(int i=0;i<size;i++){
            if(i>0&&i<size-1) {
                if (array[i] <= array[i+1] && array[i] <= array[i - 1]) {
                    System.out.println(array[i]);
                }
            }
            else if(i==size-1){
                if(array[i]<=array[i-1]){
                    System.out.println(array[i]);
                }
            }
            else
                if(array[i]<=array[i+1]){
                    System.out.println(array[i]);
                }
        }
    }
}
