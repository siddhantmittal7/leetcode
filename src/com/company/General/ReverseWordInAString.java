package com.company.General;

public class ReverseWordInAString {

    public static String reverseWords(String s) {

        s = s.trim();

        String[] s_array = s.split(" ");

        if(s_array.length == 0){
            return "";
        }

        String out = "";

        for(int i=s_array.length-1;i>=0;i--){
                if(!s_array[i].equals(""))
                out = out + s_array[i].trim() + " ";
        }

        return out.trim();
    }

    public static void main(String[] args){
        System.out.print(reverseWords("     the   sky is blue        "));
    }

}
