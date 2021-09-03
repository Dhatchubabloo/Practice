package com.zoho.l2_programs;

import java.util.Scanner;

public class PROGRAM_Pattern {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        int mid = (word.length()-1)/2;
        String temp="";
        for(int i=mid;i<word.length();i++)
            temp +=word.charAt(i);
        for(int i=0;i<mid;i++)
            temp+=word.charAt(i);
        int row = temp.length();
        int col = (temp.length()*2)-1;
        int y=1;//to get straight pattern remove thid y,put(i+1)
        for(int i=0;i<row;i++){
            int index=i;
            for(int j=0;j<col;j++){
                if(j<col-(i+y)){
                    System.out.print(" ");
                }
                else{
                    int x=0;
                    while(index>=0) {
                        System.out.print(temp.charAt(x));
                        x++;
                        index--;
                    }
                }
            }
            y++;
            System.out.println();
        }
    }
}
