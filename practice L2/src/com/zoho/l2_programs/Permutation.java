package com.zoho.l2_programs;

import java.util.Scanner;

public class Permutation {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        int len = word.length();
        permute(word,0,len-1);
    }

    private static void permute(String word, int l, int r) {
        if(l==r){
            System.out.println(word);
        }
        else{
            for(int i=l;i<=r;i++){
                word = swap(word,l,i);
                permute(word,l+1,r);
                word = swap(word,l,i);
            }
        }
    }
    private static String swap(String word, int i, int j) {
       char array[] = word.toCharArray();
       char temp = array[i];
       array[i] = array[j];
       array[j] = temp;
       return String.valueOf(array);
    }
}
