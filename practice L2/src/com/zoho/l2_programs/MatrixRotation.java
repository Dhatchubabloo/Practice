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
            for (int i = 0; i < col; i++) {
                for (int j = row - 1; j >= 0; j--) {
                    System.out.print(mat[j][i] + " ");
                }
                System.out.println();
            }
    }
}
