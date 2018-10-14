package com.company.DynamicProgramming;

public class DecodeWays {


    public static int decodeWays(String s){

        if(s == null || s.length() == 0 || s.equals("") ){
            return 0;
        }


        int[] dp = new int[s.length()+1];

        dp[0] = 1;
        dp[1] = Integer.valueOf(s.charAt(0) -'0') != 0 ? 1 : 0;

        int ways = 1;
        for(int i=2;i<=s.length();i++){
            int firstDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));

            if(firstDigit > 0 && firstDigit <= 9){
                dp[i] = dp[i] + dp[i-1];
            }

            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args){
        String s = "22";

        System.out.print(decodeWays(s));
    }
}
