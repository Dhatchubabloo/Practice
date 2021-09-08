package sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int array[] = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scan.nextInt();
        }
        for(int i=0;i<number;i++){
            int min = array[i];
            int index = 0;
            int count=0;
            for(int j=i+1;j<number;j++){
                if(array[j]<min){
                    min = array[j];
                    index = j;
                    count++;
                }
            }
            if(count==0){
                index = i;
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        for (int i = 0; i < number; i++) {
            System.out.println(array[i]);
        }
    }
}
