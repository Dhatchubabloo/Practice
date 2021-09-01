package sorting;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int array[] = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scan.nextInt();
        }
        msort(array,0,number-1);
    }
    private static void msort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        if(i<j){
            int mid = (i+j)/2;
            msort(array, i, mid);
            msort(array,mid+1,j);
            merge(array,i,mid,j);
        }
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int i =low;
        int j = mid+1;
        int k =low;
        int temp[] = new int[array.length];
        while(i<=mid&&j<=high){
           if(array[i]<array[j]){
               temp[k]=array[i];
               k++;i++;
           }
           else{
               temp[k] = array[j];
               k++;j++;
           }
        }
        while(i<=mid){
            temp[k] = array[i];
            k++;i++;
        }
        while(j<=high){
            temp[k] = array[j];
            k++;j++;
        }
       for(i=0;i< array.length;i++){
           array[i] = temp[i];
       }
       for(i=0;i< array.length;i++){
           System.out.println(array[i]);
       }
    }
}
