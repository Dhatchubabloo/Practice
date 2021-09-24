package com.zoho.l2_programs;
/*
Input: n = 23
Output: 55
Explanation: reverse(23) = 32,then 32+23
= 55 which is a palindrome. k<=5
 */
import java.util.Scanner;

public class SumOfPalindromeNumber {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int count=0;
        for(int i=1;i<=5;i++){
            int temp = number;
            int val=0;
            while(temp>0){
              val = (val*10)+temp%10;
              temp /=10;
            }
            if(val==number) {
                System.out.println(number);
                System.out.println(i);
                break;
            }
            else {
                number += val;
                temp = number;
                int num = 0;
                while (temp > 0) {
                    num = (num * 10) + temp % 10;
                    temp /= 10;
                }
                if (num == number) {
                    System.out.println(number);
                    System.out.println("Number of operations"+i);
                    break;
                } else count++;
            }
        }
        if(count==5){
            System.out.println(-1);
        }
    }
}
