package com.zoho.l2_programs;

import java.util.Scanner;

public class LeftArrayRotation {
        public static void main(String[]args) {
            Scanner scan = new Scanner(System.in);
            int size = scan.nextInt();
            int array[] = new int[size];
            for (int i = 0; i < size; i++) {
                int value = scan.nextInt();
                array[i] = value;
            }
            for(int i=0;i<2;i++){
                int front = array[size-1];
                for(int j=size-1;j>0;j--) {
                    array[j] = array[j-1];
                }
                array[0] = front;
            }
            for(int i=0;i<size;i++){
                System.out.print(array[i]+" ");
            }
        }
    }
