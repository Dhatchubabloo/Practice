package com.zoho.l2_programs;

import java.util.Scanner;

public class OddEvenSorting {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        int evenArray[]={};
        int oddArray[] ={};
        if(size%2==0){
             evenArray = new int[size/2];
            oddArray = new int[size/2];
        }
       else{
            evenArray = new int[(size/2)+1];
            oddArray = new int[size/2];
        }
        int x=0;
        for(int i=0;i<size;i+=2){
            evenArray[x] =array[i];
            x++;
        }
        x=0;
        for(int i=1;i<size;i+=2){
            oddArray[x] =array[i];
            x++;
        }
        for(int i=0;i< evenArray.length;i++){
            int min  = evenArray[i];
            int index=0;
            for(int j=i+1;j< evenArray.length;j++){
                if(evenArray[j]<min){
                    min = evenArray[j];
                    index=j;
                }
            }
            if(min==evenArray[i]){
                index = i;
            }
            int temp = evenArray[i];
            evenArray[i] = min;
            evenArray[index] = temp;
        }
        for(int i=0;i< oddArray.length;i++){
            int min  = oddArray[i];
            int index=0;
            for(int j=i+1;j< oddArray.length;j++){
                if(oddArray[j]>min){
                    min = oddArray[j];
                    index=j;
                }
            }
            if(min==oddArray[i]){
                index = i;
            }
            int temp = oddArray[i];
            oddArray[i] = min;
            oddArray[index] = temp;
        }
        int y=0;
        for(int i=0;i<size;i++){
            array[i] = oddArray[y];
            i++;
            array[i] = evenArray[y];
            y++;
        }
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
    }
}
