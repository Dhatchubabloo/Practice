package com.zoho.l2_programs;

import java.util.Scanner;

public class FoundMatrix {
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter row");
        int row = scan.nextInt();
        System.out.println("Enter column");
        int col = scan.nextInt();
        int mat[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = scan.nextInt();
            }
        }
        System.out.println("Enter row");
        int row1 = scan.nextInt();
        System.out.println("Enter column");
        int col1 = scan.nextInt();
        int mat1[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                mat1[i][j] = scan.nextInt();
            }
        }int i=0,count=0;
                for (int k = 0; k < row; k++) {
                    int temp=0;
                    if(i<row1) {
                        int j=0;
                        for (int l = 0; l < col; l++) {
                            if (j < col1) {
                                if (mat[k][l] == mat1[i][j]) {
                                    count++;
                                    temp++;
                                    j++;
                                }
                            }
                            else
                                break;
                        }
                    }
                    if(temp==col1)
                        i++;
                }
                if(count==(row1*col1)){
                    System.out.println("True : The smaller matrix was present in the bigger matrix");
                }
                else
                    System.out.println("False : The smaller matrix was not present in the bigger matrix");
            }
        }
