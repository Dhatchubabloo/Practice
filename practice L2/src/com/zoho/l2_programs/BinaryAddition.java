package com.zoho.l2_programs;

import java.util.Scanner;

public class BinaryAddition {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        String number1 = scan.next();
        String number2 = scan.next();
        int count=0;
        int len = number1.length()-number2.length();
        StringBuffer sb = new StringBuffer(number2);
        number2 = new String(sb.reverse());
        for(int i=0;i<len;i++){
            number2+=0;
        }
        StringBuffer sb2 = new StringBuffer(number2);
        number2 = new String(sb2.reverse());
        String result="";
        int temp=0;
        for(int i=number1.length()-1;i>=0;i--){
            int num1 =number1.charAt(i)-48;
            int num2=number2.charAt(i)-48;
            if(temp+num1+num2==2){
                result+=0;
                temp=1;count++;
            }
            else if(temp+num1+num2==3){
                result+=1;
                temp=1;count++;
            }
            else
                result+=temp+num1+num2;
        }
        StringBuffer sb1;
        if(count>0){
            sb1 = new StringBuffer(result+temp);
        }
        else {
            sb1 = new StringBuffer(result);
        }

        System.out.println(sb1.reverse());
    }
}
