package Zcart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        int min=0;
        int max =2;
       int val = (int)Math.floor((Math.random()*(max-min+1)+min));
        System.out.println((int)val);
    }
}
