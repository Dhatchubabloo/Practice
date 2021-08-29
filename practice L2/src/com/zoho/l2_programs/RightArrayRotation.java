package com.zoho.l2_programs;

import java.util.Scanner;

public class RightArrayRotation {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        for(int i=0;i<2;i++){
            int front = array[0];
            for(int j=1;j< array.length;j++) {
                array[j-1] = array[j];
            }
            array[array.length-1] = front;
        }
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
    }
}
