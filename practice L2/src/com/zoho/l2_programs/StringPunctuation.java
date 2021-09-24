package com.zoho.l2_programs;

import java.util.Scanner;

public class StringPunctuation {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int start=0;
        int end = word.length()-1;
        char[]array = word.toCharArray();
        while(start<end) {
            if (!((array[start] >= 'a' && array[start] <= 'z') || (array[start] >= 'A' && array[start] <= 'Z') || (array[start] >= '0' && array[start] <= '9'))) {
                start++;
            }
            if (!((array[end] >= 'a' && array[end] <= 'z') || (array[end] >= 'A' && array[end] <= 'Z') || (array[end] >= '0' && array[end] <= '9'))) {
                end--;
            } else {
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println(String.valueOf(array));
    }
}
