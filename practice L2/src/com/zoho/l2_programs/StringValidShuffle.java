package com.zoho.l2_programs;

import java.util.Scanner;

public class StringValidShuffle {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String word1 = scan.nextLine();
        String word2 = scan.nextLine();
        String result = scan.nextLine();
        System.out.println(result.length());
        int size=0,size1=0,i=0,count=0;
        while(i<result.length()){
                if (size<word1.length()&&word1.charAt(size) == result.charAt(i)) {
                    count++;
                    System.out.println(result.charAt(i));
                    size++;
                    i++;
                }
            else if(size1<word2.length()&&word2.charAt(size1)==result.charAt(i)){
                count++;size1++;
                    System.out.println(result.charAt(i));
                i++;
            }
            else{
                break;
            }
        }
        System.out.println(count);
        if(count==result.length()){
            System.out.println("valid shuffle");
        }
        else
            System.out.println("invalid");

    }
}
