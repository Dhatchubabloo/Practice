package sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[]args) {
        int[] array1 = {1,2};
        int[] array2 = {1,2};
        int result[] = new int[array1.length + array2.length];
        int i = 0,j=0,k=0;
        while(i< array1.length&&j< array2.length){
            if(array1[i]<array2[j]){
                 result[k] = array1[i];
                 i++;k++;
            }
            else{
                result[k] = array2[j];
                k++;j++;
            }
        }
        while(i<array1.length){
            result[k] = array1[i];
            i++;k++;
        }
        while(j< array2.length){
            result[k] = array2[j];
            k++;j++;
        }
        System.out.println(Arrays.toString(result));
        if(result.length%2!=0){
            int mid = result.length/2;
            System.out.println(result[mid]);
        }
        else
        {
            int mid = result.length/2;
            float val = result[mid]+result[mid-1];
            System.out.println(val/2);
        }
    }
}