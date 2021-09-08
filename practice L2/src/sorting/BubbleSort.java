package sorting;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int array [] = new int[number];
        for(int i=0;i<number;i++){
            array[i] = scan.nextInt();
        }
        int res = number;
        for(int i=0;i<number;i++){
            int count=0;
            for(int j=0;j<res-1;j++){
                if(array[j]<array[j+1]){
                    count++;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(count==0){
                break;
            }
            res--;
        }
        for(int i=0;i<number;i++){
            System.out.println(array[i]);
        }
    }
}
