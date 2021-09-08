package com.zoho.l2_programs;

import java.util.Scanner;

public class MatrixRotation {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter row");
        int row = scan.nextInt();
        System.out.println("Enter column");
        int col = scan.nextInt();
        int mat[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j]= scan.nextInt();
            }
        }
        System.out.println("90 degree");
            for (int i = 0; i < col; i++) {
                for (int j = row - 1; j >= 0; j--) {
                    System.out.print(mat[j][i] + " ");
                }
                System.out.println();
            }
        System.out.println("180 degree");
        for (int i = row-1; i >=0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("270 degree");
        for (int i = col-1; i >=0; i--) {
            for (int j =0; j <row; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("360 degree");
        for (int i = 0; i <row; i++) {
            for (int j =0; j <col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Matrix Transpose");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
    }
}
