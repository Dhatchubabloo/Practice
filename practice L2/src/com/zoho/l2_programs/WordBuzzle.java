package com.zoho.l2_programs;

import java.util.ArrayList;
import java.util.Scanner;

public class WordBuzzle {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter rows");
        int row = scan.nextInt();
        System.out.println("Enter columns");
        int col = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter String");
        String word = scan.nextLine();
        char mat[][]=new char[row][col];
        int x=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j] = word.charAt(x);
                x++;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Enter subString");
       String subString = scan.next();
        int y=0;
        int count=1;
        int main=0,endRow=0,endcol=0,startRow=0,startcol=0;
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if(subString.charAt(y)==mat[i][j]&&y < subString.length()) {
                    count++;
                    y++;startRow=i;startcol=j;
                    boolean flag = true;
                    while (flag) {
                        if (subString.charAt(y) == mat[i][++j] && y < subString.length()-1&&j<col) {
                            count++;
                            y++;endRow=i;endcol=j;
                        } else if (subString.charAt(y) == mat[++i][--j] && y < subString.length()-1&&i<row) {
                            count++;
                            y++;endRow=i;endcol=j;
                        } else {
                            main++;
                            flag = false;
                        }
                    }
                }
                if(main!=0){
                    break;
                }
            }
            if(main!=0){
                break;
            }
        }
        System.out.println(count);
        if(count==subString.length()){
            System.out.println("True:"+subString);
            System.out.println("Starting index :"+startRow+","+startcol);
            System.out.println("Ending index :"+endRow+","+endcol);
        }
        else
            System.out.println("False:"+subString);

    }
}
