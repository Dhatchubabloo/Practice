package sorting;


public class SortBySumOfDigits {
    public static void main(String[]args){
        int array[] = {21,41,12,24,14};
        int size = array.length;
        int sum;
        for(int i=0;i< size;i++){
            int temp = array[i];
            sum = digits(temp);
            for(int j=i+1;j<size;j++){
                temp = array[j];
                int rem = digits(temp);
                if(rem<sum){
                    int val = array[j];
                    array[j] = array[i];
                    array[i]=val;
                    sum=rem;
                }
                else if(rem==sum){
                    if(array[i]>array[j]){
                        int val = array[i];
                        array[i] = array[j];
                        array[j] = val;
                    }
                }
            }
        }
        for(int i:array)
            System.out.print(i+" ");
    }
    static int digits(int temp){
        int rem=0;
        while(temp>0){
            rem+=temp%10;
            temp=temp/10;
        }
        return rem;
    }
}
