package com.zoho.l2_programs;

import java.util.Scanner;
public class CombinationOfString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.next();
        char array[] = line.toCharArray();
        int len = array.length;
        int i = 0;
        combine(array, len, i);
    }
    public static void combine(char[] array, int len, int i) {
        for (int j = 0; j < len - i; j++) {
            String temp = "";
            for (int k = i; k <= j + i; k++) {
                temp += array[k];
            }
            System.out.println(temp);
        }
        if(i<len)
            combine(array,len,++i);
    }





//        static void printCombinations(char[] input,
//                                      int index,
//                                      char[] output,
//                                      int outLength)
//        {
//                if (input.length == index)
//            {
//                    System.out.println(String.valueOf(output));
//                return;
//            }
//
//                output[outLength] = input[index];
//
//              output[outLength + 1] = ' ';
//
//            printCombinations(input, index + 1, output,
//                    outLength + 2);
//
//                if(input.length!=index + 1)
//                printCombinations(input, index + 1, output,
//                        outLength + 1);
//        }
//
//        public static void main(String[] args)
//        {
//            char input[] = "ram".toCharArray();
//            char []output = new char[100];
//
//            printCombinations(input, 0, output, 0);
//        }
    }
