package com.company.General;

public class MinimumWindowSubstring {

    public static boolean containsAllChar(String s,String t){

        for(int i=0;i<t.length();i++){
            if(!s.contains(String.valueOf(t.charAt(i)))){
                return false;
            }else{
                s = s.replaceFirst(String.valueOf(t.charAt(i)),"");
            }
        }

        return true;
    }

    public static String minWindow(String s, String t) {

        if(s.length() == 0 || s == null){
            return "";
        }

        String subString = "";
        String minSubString = "";
        int minlength = Integer.MAX_VALUE;

        for(int i=0;i<s.length();i++){
            subString = subString + s.charAt(i);


            while(containsAllChar(subString,t)){
                if(subString.length() < minlength) {
                    minSubString = subString;
                    minlength = subString.length();
                }
                subString = subString.substring(1,subString.length());
            }
        }

        return minSubString;
    }

    public static void main(String[] args){
        String s = "cabwefgewcwaefgcf";
        String t = "cae";




        System.out.print(minWindow(s,t));
    }


}
