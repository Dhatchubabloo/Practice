package com.zoho.l2_programs;

import java.util.ArrayList;
import java.util.Scanner;

public class SortByFactors {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            array[i] = value;
        }
        ArrayList <Integer>list = new ArrayList();
        for(int i=0;i<size;i++){
            int count=0;
            for(int j=2;j<array[i];j++){
                if(array[i]%j==0){
                    count++;
                }
            }
            list.add(array[i]);
            list.add(count);
        }

        for(int j=0;j<size;j++) {
            int max = list.get(1);

            int index=1;

            for (int i = 3; i < list.size(); i += 2) {
                if (list.get(i) > max) {
                    max = list.get(i);
                    index=i;
                }
            }

            array[j]= list.get(index-1);
            list.remove(index);
            list.add(index,-1);

        }
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
    }
}
