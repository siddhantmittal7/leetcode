package com.company.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {



        int[][] ways = new int[amount+1][coins.length+1];
        int value = coinChnageDp(coins,coins.length,amount,0,ways);

        if(value == Integer.MAX_VALUE)
            return -1;
        else
            return value;

    }

    public static int coinChnageDp(int[] coins, int m, int amount,int count,int[][] ways){


        if(amount == 0){
            return count;
        }

        if(amount < 0)
            return Integer.MAX_VALUE;

        if(m<=0 && amount >0)
            return Integer.MAX_VALUE;

        if(ways[amount][m]>0)
            return ways[amount][m];


        ways[amount][m] = Math.min(coinChnageDp(coins,m,amount-coins[m-1],count+1,ways),coinChnageDp(coins,m-1,amount,count,ways));
        return ways[amount][m];

    }

    public static void main(String[] args){

        int[] nums = {1,2,5};

        int n = 11;

        System.out.print(coinChange(nums,n));
    }
}
