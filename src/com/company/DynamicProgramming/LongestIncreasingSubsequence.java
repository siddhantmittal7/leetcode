package com.company.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    public static int lengthOfLIS(int[] a) {

        if(a == null || a.length == 0){
            return 0;
        }

        int[] l = new int[a.length];

        l[0] = 1;

        for(int i=1;i<a.length;i++){

            int max = 0;
            for(int j=0;j<i;j++){
                if(l[j] > max && a[j] <= a[i]){
                    max = l[j];
                }
            }
            l[i] = max + 1;
        }

        Arrays.sort(l);
        return l[a.length-1];


    }


    public static void main(String[] args){

        int[] nums = {4,10,4,3,8,9};

        int[][] c = new int[nums.length+1][nums.length+1];


        System.out.print(lengthOfLIS(nums));
    }
}
