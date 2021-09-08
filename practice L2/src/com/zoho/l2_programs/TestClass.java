package com.zoho.l2_programs;

import java.util.ArrayList;

public class TestClass {
    public static void main(String []args){
        ArrayList al = new ArrayList();
        for(int i=0;i<5;i++){
            al.add(i);
        }
        al.remove(2);
        al.add(2,10);
        System.out.println(al);
    }
}
