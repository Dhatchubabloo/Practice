package com.zoho.l2_programs;

import java.util.Scanner;

public class StringReversal {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Sentence");
        String line = scan.nextLine();
        int strlen = line.length();
        int k=strlen-1;
        String [] array = line.split(" ");
        for (int i=0;i< array.length;i++){
            String temp = array[i];
            int len = temp.length();
            int j=0;
            while(j<len) {
                    if (line.charAt(k)!=' '){
                        System.out.print(line.charAt(k));
                        j++;
                        k--;
                    }
                    else
                        k--;
                }
            System.out.print(" ");
            }

        }
    }
