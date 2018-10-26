package com.company.General;

public class PalindromeNumber {

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

    public static boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        return isPalindromehelper(s);
    }

    public static void main(String[] args){

        System.out.print(isPalindrome(112343383));
    }
}
