package com.zoho.l2_programs;

import java.util.ArrayList;

public class TestClass {
    public static void main(String []args){
       String str = "home";
       StringBuffer sb = new StringBuffer(str);
        System.out.println(str);
        str = new String(sb.reverse());
        System.out.println(str);

    }
}
