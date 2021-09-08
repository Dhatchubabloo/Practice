package sorting;
public class  MergeSort{

    void merger(int []arr,int left,int mid,int right){
        int ls = mid-left+1;
        int rs = right-mid;
        int leftArray[] = new int[ls];
        int rightArray[] = new int[rs];

        for(int i=0;i<ls;i++){
            leftArray[i] = arr[i+left];
        }
        for(int i=0;i<rs;i++){
            rightArray[i] = arr[i+mid+1];
        }
        int i=0;
        int j=0;int k=left;
        while(i<ls&&j<rs){
            if(leftArray[i]<rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<ls){
            arr[k] = leftArray[i];
            i++;k++;
        }
        while(j<rs){
            arr[k] = rightArray[j];
            j++;k++;
        }
    }
    public void sort(int arr[],int left,int right){
        if(right>left){
            int mid = (right+left)/2;
            sort(arr,left,mid);
            sort(arr,mid+1,right);
            merger(arr,left,mid,right);
        }
    }
    public static void main(String[]args){
        int arr[] = {5,2,9,12,6,34,25};
        MergeSort merge = new MergeSort();
        merge.sort(arr,0, arr.length-1);
        for(int i:arr)
            System.out.print(i+" ");
    }
}