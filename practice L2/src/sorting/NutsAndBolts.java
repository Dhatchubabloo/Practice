package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class NutsAndBolts {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        char nuts[] = new char[size];
        char bolts[] = new char[size];
        for(int i=0;i<size;i++){
            nuts[i] = scan.next().charAt(0);
        }
        for(int i=0;i<size;i++){
            bolts[i] = scan.next().charAt(0);
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size-1;j++){
                if(nuts[j]>nuts[j+1]){
                    char temp = nuts[j];
                    nuts[j] = nuts[j+1];
                    nuts[j+1]=temp;
                }
                if(bolts[j]>bolts[j+1]){
                    char temp = bolts[j];
                    bolts[j] = bolts[j+1];
                    bolts[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}
