package com.zoho.l2_programs;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int size =  scan.nextInt();
        int array[] = new int[size];
        for(int i=0;i<size;i++){
            int value = scan.nextInt();
            array[i] = value;
        }
        for(int i=0;i<size;i++){
            int min  = array[i];
            int index=0;
            for(int j=i+1;j<size;j++){
                if(array[j]<min){
                    min = array[j];
                    index=j;
                }
            }
            if(min==array[i]){
                index = i;
            }
            int temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
        for(int i=0;i<size;i++){
            System.out.println(array[i]);
        }
    }
}
