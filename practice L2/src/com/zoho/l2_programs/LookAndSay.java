package com.zoho.l2_programs;

import java.util.Scanner;

public class LookAndSay {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int totalCount=0;
        String value="";
        for(int i=1;i<=number;i++){
            String demo="";
            if(i==1) {
                value += 1;
                totalCount+=1;
                System.out.println(value);
            }
            else{
                String temp="";
                int count=0;
                char val = value.charAt(0);
                int len = value.length();
                for(int j=0;j<=value.length();j++){
                   count=0;
                   boolean flag = true;
                   while(flag&&j<value.length()) {
                       if(val == value.charAt(j)) {
                           totalCount+=(value.charAt(j)-48);
                           temp=""+val;
                           count++;
                           j++;
                       }
                       else {
                           flag = false;
                       }
                   }
                   if(count!=len){
                       demo+=count+temp;
                       val = value.charAt(j);
                       totalCount+=(val-48); totalCount+=count;
                       len=len-count;
                       j--;
                   }
               }
                value=demo+count+temp;
               totalCount+=count;
                System.out.println(value);;
            }
        }
        System.out.println(totalCount);
    }
}
