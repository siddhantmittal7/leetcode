package com.company.General;

public class isSubsequence {

    public static boolean isSubsequence(String s, String t) {

        if(t == null)
            return false;

        if(s == null || s.length() == 0)
            return true;

        int shortS = 0;

        for(int i=0;i<t.length();i++){
            if(shortS == s.length()){
                return true;
            }
            if(t.charAt(i) == s.charAt(shortS)){

                shortS++;
            }
        }

        if(shortS == s.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String num = "199100199";

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s,t));
    }
}
