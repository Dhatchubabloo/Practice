package com.zoho.l2_programs;

import java.util.Scanner;

public class MonoDigit {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number");
        String number = scan.next();
        int main = number.charAt(0)-48;
        int subMain = main;
        int count=0;
        for(int i=1;i<number.length();i+=2){
            int temp1 = number.charAt(i)-48;
            if(i+1<number.length()) {
                int temp2 = number.charAt(i + 1) - 48;
                if (temp1 + temp2 == main) {
                    subMain = (subMain * 10) + (temp1 + temp2);
                } else if (temp1 - temp2 == main) {
                    subMain = (subMain * 10) + (temp1 - temp2);
                } else {
                    count++;
                    break;
                }
            }
            else {
                count++;
                break;
            }

        }
        if(count==0)
            System.out.println("The mono Digit number is :"+subMain);
        else
            System.out.println("Cannot create a mono digit number");
    }
}
