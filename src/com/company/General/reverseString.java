package com.company.General;

import java.util.Arrays;

public class reverseString {

    public static int wordCount(String s){

        if(s==null || s.length() == 0){
            return 0;
        }

        int wordCount = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                wordCount++;
                i++;
                while(i<s.length() && s.charAt(i) == ' '){
                    i++;
                }
            }
        }

        if(s.charAt(s.length()-1) != ' '){
            wordCount++;
        }

        return wordCount;

    }

    public static void main(String[] args){
        String s = "siddhant sfssf sfsf ";
        System.out.println(wordCount(s));
    }
}
