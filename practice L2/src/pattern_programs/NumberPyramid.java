package pattern_programs;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int value=1;
        for(int i=0;i<number;i++){
            for(int j=number;j<=number+i;j++){
                System.out.print(value+" ");
                value++;
            }
            System.out.println();
        }
    }
}
