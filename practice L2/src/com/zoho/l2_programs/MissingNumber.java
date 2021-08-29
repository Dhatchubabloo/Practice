package com.zoho.l2_programs;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String  [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array Size");
        int size = scan.nextInt();
        System.out.println("Enter the Elements");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        int temp = array[0]-0;
        for(int i=1;i<size;i++){
            int num = array[i]-i;
            if(num!=temp){
                System.out.println("The missing Number was:"+(temp+i));
                temp++;
            }
        }
    }
}
