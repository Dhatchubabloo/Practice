package com.zoho.l2_programs;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        String temp ="";
        for(int i=word.length()-1;i>=0;i--){
            temp+=word.charAt(i);
        }
        if(word.equals(temp))
            System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");
    }
}
