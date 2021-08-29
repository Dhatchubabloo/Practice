package com.zoho.l2_programs;

import java.util.Scanner;

public class GrandsonProblem {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter row");
        int child = scan.nextInt();
        System.out.println("Enter column");
        int parent = scan.nextInt();
        System.out.println("Enter elements");
        String childMat[][] = new String[child][parent];
        for(int i=0;i<child;i++){
            for(int j=0;j<parent;j++){
                childMat[i][j] = scan.next();
            }
        }
        if(childMat!=null) {
            System.out.println("Enter string");
            String input = scan.next();
            String value = "";
            int temp = 0;
            for (int i = 0; i < child; i++) {
                for (int j = 1; j < parent; j++) {
                    if (childMat[i][j].equals(input)) {
                        value = childMat[i][--j];
                        temp++;
                        break;
                    }
                }
                if (temp != 0) {
                    break;
                }
            }
            int count = 0;
            for (int i = 0; i < child; i++) {
                for (int j = 1; j < parent; j++) {
                    if (childMat[i][j].equals(value)) {
                        System.out.println(childMat[i][--j]);
                        j++;
                        count++;
                    }
                }
            }
            System.out.println("Ronaldos's grandson " + count);
        }
    }
}
