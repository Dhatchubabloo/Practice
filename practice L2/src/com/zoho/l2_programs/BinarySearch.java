package com.zoho.l2_programs;
import java.util.Scanner;
public class BinarySearch {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int array[] = new int[size];
        for(int i=0;i<size;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Enter the element to be find:");
        int find = scan.nextInt();
        int mid = (size)/2;
        for(int i=0;i<size;i++){
            if(find==array[mid]){
                System.out.println(mid);
                break;
            }
            else if(find>array[mid]){
                mid++;
                i=mid;
            }
            else if(find<array[mid]){
                mid--;
                i=mid;
            }
        }
    }
}
