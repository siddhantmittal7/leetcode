package com.company.General;

public class ValidPalindrome {

    public static boolean isPalindromehelper(String s){

        int size = (s.length()/2);
        for(int i=0;i<=size;i++){
            if(s.charAt(i) == s.charAt(s.length()-i-1))
                continue;
            else
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {

        if(s.length() == 0 || s == " ")
            return true;

        s = s.replaceAll("[-?,\"\';!():`.@#\\s]+", "").toLowerCase();

        if(s.length() == 0)
            return true;
        else
            return isPalindromehelper(s);



    }

    public static void main(String[] args){
        System.out.print(isPalindrome("  "));
    }
}
