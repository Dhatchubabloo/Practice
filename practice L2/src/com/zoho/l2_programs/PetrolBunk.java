package com.zoho.l2_programs;

import java.util.Scanner;

public class PetrolBunk {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter initial amount of petrol");
        int initial = scan.nextInt();
        System.out.println("Enter no of petrolBunks");
        int number = scan.nextInt();
        int array[]= new int[number*2];
        System.out.println("Enter the distance between the each petrolbunks");
        for(int i=0;i<number;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Enter the capacity of each petrolbunks");
        for(int i=number;i<number*2;i++){
            array[i]= scan.nextInt();
        }
        int j = array.length/2;
        for(int i=0;i<number;i++){
            int consume = initial-array[i];
            initial = consume+array[j];
            j++;
        }
        System.out.println("The remaining petrol in the car is:"+initial+" liters");
    }
}
