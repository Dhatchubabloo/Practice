package pattern_programs;

import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[]args){
        Scanner scan =new Scanner(System.in);
        int number = scan.nextInt();
        for(int i=0;i<number;i++){
            for(int j=0;j<number-i;j++){
                System.out.print(" ");
            }
            for(int k=number-i;k<=number;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=number-1;i>=0;i--){
            for(int j=0;j<number-i+1;j++){
                System.out.print(" ");
            }
            for(int k=number-i;k<number;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
