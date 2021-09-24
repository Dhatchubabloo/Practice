package com.zoho.l2_programs;

public class RemoveSubString {
    public static void main(String[]args){
        String word = "fffoxoxoxfxofox";
        String subWord = "fox";
        char subArray[] = subWord.toCharArray();
        for(int i=0;i<word.length();i++){
           String tempWord="";
            int j=0,temp=i,count=0;
            while(j<subWord.length()){
                if(word.charAt(i)==subArray[j]){
                    i++;j++;count++;
                }
                else {
                    break;
                }
            }
            if(count==subWord.length()) {
                i = -1;
                for (int k = 0; k < word.length(); k++) {
                    if (!(k >= temp && k < temp + subWord.length())) {
                        tempWord += word.charAt(k);
                    }
                }
                word = tempWord;
            }
            else {
                i =temp;
            }
        }
        System.out.println(word);
    }
}
