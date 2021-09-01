package sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int array[] = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scan.nextInt();
        }
        for(int i=0;i<number;i++){
            int key = array[i];
            int j = i-1;
            while(j>=0&&key<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        for (int i = 0; i < number; i++) {
            System.out.println(array[i]);
        }
    }
}
