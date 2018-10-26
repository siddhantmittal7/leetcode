package com.company.DynamicProgramming;

public class LongestPalindromeSubstring {

    public static boolean isPalindrome(String s){

        int size = (s.length()/2);
        for(int i=0;i<=size;i++){
            if(s.charAt(i) == s.charAt(s.length()-i-1))
                continue;
            else
                return false;
        }
        return true;
    }

    public static String longestPalindrome(String s) {

        if(s.length() == 0){
            return "";
        }

        if(isPalindrome(s))
            return s;

        int[][] c = new int[s.length()+1][s.length()+1];

        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<s.length()+1;j++){
                c[i][j]  = -1;
            }
        }
        c[0][s.length()] = longestPalindrome(s,0, s.length(),c);

        int max = 0;
        int max_i = 0;
        int max_j = 0;

        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<s.length()+1;j++){
                if(c[i][j] > max){
                    max_i = i;
                    max_j = j;
                    max = c[i][j];
                }
            }
        }

        return s.substring(max_i,max_j);
    }

    public static int longestPalindrome(String s,int i, int j,int[][] c){

        if(s.length() == 0 || i > s.length() || j<0 || i>j){
            return 0;
        }
        if(c[i][j] >=0)
            return c[i][j];
        if(isPalindrome(s.substring(i,j)))
            c[i][j] = s.substring(i,j).length();
        else{
            c[i][j] = 0;
            c[i+1][j] = longestPalindrome(s,i+1,j,c);
            c[i][j-1] = longestPalindrome(s,i,j-1,c);
        }

        return c[i][j];
    }

    public static void main(String[] args){

        System.out.print(longestPalindrome(""));
    }
}
