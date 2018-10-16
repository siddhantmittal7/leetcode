package com.company.DynamicProgramming;

public class LongestPalindromeSubsequence{

    public static int longestCommonSubsequence_helper(String s1,String s2,int[][] c,int i,int j){

        if(i==0 || j==0)
            return 0;
        if(c[i][j] > 0)
            return c[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            c[i][j] = longestCommonSubsequence_helper(s1,s2,c,i-1,j-1) +1;
        }else{
            c[i][j] = Math.max(longestCommonSubsequence_helper(s1,s2,c,i-1,j),
                    longestCommonSubsequence_helper(s1,s2,c,i,j-1));
        }

        return c[i][j];
    }

    public static int longestPalindromeSubsequence(String s1){

        String s2 = "";

        for(int i=s1.length()-1;i>=0;i--){
            s2 = s2 + s1.charAt(i);
        }

        int[][] c= new int[s1.length()+1][s2.length()+1];

        return longestCommonSubsequence_helper(s1,s2,c,s1.length(),s2.length());
    }

    public static void main(String[] args){

        String s = "abcdaf";

        System.out.print(longestPalindromeSubsequence(s));
    }


}
