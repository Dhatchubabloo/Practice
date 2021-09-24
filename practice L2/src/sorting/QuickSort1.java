package sorting;

import java.util.Scanner;
//QuickSort with right pivot
public class QuickSort1 {
    static void sort(int []array,int left,int right){
        if(left<right) {
            int pivot = array[right];
            int i = left;
            int j = right;
            while (j > i) {
             j=j-1;
                while (array[i] < pivot&&i<=right) {
                    i++;
                }
                while (array[j] > pivot&&j>=left) {
                    j--;
                }
                if(j>i){
                    swap(array,i,j);
                }
            }
            swap(array,right,i);
            sort(array,left,i-1);
            sort(array,i+1,right);
        }
    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] =temp;
    }
    public static void main(String []args){
        //Scanner scan = new Scanner(System.in);
        int array[] = {4,7,2,9,8,1,6,5,3};
        sort(array,0, array.length-1);
        for(int i:array)
            System.out.print(i+" ");
    }
}
