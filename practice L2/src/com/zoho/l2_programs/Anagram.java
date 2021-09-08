package com.zoho.l2_programs;

import java.util.Scanner;

public class Anagram {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        String word1 = scan.next();
        if(word.length()==word1.length()) {
            int k = 0;
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == word1.charAt(k)) {
                        k++;
                        count++;
                        break;
                    }
                }
            }
            if (count == word.length())
                System.out.println("Anagram");
            else
                System.out.println("Not Anagram");
        }
        else
            System.out.println("Not Anagram");


    }
}
