package com.zoho.l2_programs;

import java.util.Scanner;

public class DateSorter {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter count");
        int count = scan.nextInt();
        Long[]dateArray = new Long[count];
        String[]dateString = new String[count];
        System.out.println("Enter dates in date format(DD-MM-YYY)");
        for(int i=0;i<count;i++) {
            String result = "";
            String date = scan.next();
            dateString[i] =date;
            String[] format = date.split("-");
            for (int j = format.length - 1; j >= 0; j--) {
                result += format[j];
            }
            long datelong = Long.parseLong(result);
            dateArray[i]= datelong;
        }
        for(int i=0;i<count;i++){
            for(int j=0;j<count-1;j++){
                if(dateArray[j]>dateArray[j+1]) {
                    long temp = dateArray[j];
                    dateArray[j] = dateArray[j + 1];
                    dateArray[j + 1] = temp;
                    String tempValue = dateString[j];
                    dateString[j] = dateString[j + 1];
                    dateString[j + 1] = tempValue;
                }
            }
        }
        for(String x:dateString)
            System.out.println(x);
    }
}
