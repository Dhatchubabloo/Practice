package com.zoho.l2_programs;

import java.util.Scanner;

public class StringDuplicateCount {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String spell = scan.next();
        char arr [] = spell.toCharArray();
        int len = arr.length;
        for(int i=0;i<len;i++){
            int count=1;
            int index=0;
            int k=0;
            for(int j=i+1;j<len;j++){
                int first = arr[i];
                int second = arr[j];
                if(first==second){
                    count++;
                    index=i;
                    if(count>2) {
                        arr[j] = (char) k;
                        k++;
                    }
                }
            }
            if(count>1){
                System.out.println(arr[index]+" - "+count);
            }

        }
    }
}
