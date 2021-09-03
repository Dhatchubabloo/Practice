package com.zoho.l2_programs;

import java.util.Scanner;

public class StringRecursion {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        String array[] = word.split(" ");
        for(String x:array){
            System.out.println(x);
        }
        int len = array.length-1;
        new StringRecursion().splitting(array,len);
    }
    public void splitting(String[] array,int index){
        if(index>=0) {
            System.out.println(array[index]);
            splitting(array, --index);
        }
    }
}
