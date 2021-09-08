package com.zoho.l2_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StringSorting implements Comparator{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String array[] = line.split(" ");
        ArrayList<String>list = new ArrayList<>();
        for(int i=0;i< array.length;i++){
            list.add(array[i]);
        }
        StringSorting ss = new StringSorting();
        Arrays.sort(array,ss);
        for(String i:array)
            System.out.println(i);
    }

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        if(s1.length()>s2.length()){
            return -1;
        }
        else if(s1.length()<s2.length()){
            return +1;
        }
        else
        return 0;
    }
}

