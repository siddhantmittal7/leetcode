package com.company.General;

import java.util.Arrays;

public class MaxWeight {

    public static void helper(int input, int maxWeight, int[] plates){
        Arrays.sort(plates);


        int i= 0;
        int j = input-1;

        int maxSum = Integer.MIN_VALUE;

        int ans_i = 0;
        int ans_j = 0;

        while(i<j && j > 0 && i<input){
            int sum = plates[i] + plates[j];
            if(sum <= maxWeight){
                if(sum > maxSum){
                    ans_i = i;
                    ans_j = j;
                    maxSum = sum;
                    i++;
                }
            }else{
                j--;
            }
        }

        System.out.println(ans_i + "," + ans_j);
    }

    public static void main(String[] args){
        int input = 5;
        int maxweight = 43;
        int[] sizes = {19,23,110,42,1};

        helper(input,43,sizes);

    }
}
