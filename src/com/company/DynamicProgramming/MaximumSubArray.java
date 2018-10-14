package com.company.DynamicProgramming;

public class MaximumSubArray {

    /*
    Problem Statement :
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public static int[][] initialize_memory(int[] a){

        int[][] memory = new int[a.length][a.length];

        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a.length; j++) {
                memory[i][j] = Integer.MIN_VALUE;
            }
        }

        return memory;
    }

    public static int calculate_sum(int[] a, int i, int j){

        int sum =0;

        for(int k=i;k<=j;k++){
            sum = sum + a[k];
        }

        return sum;
    }

    public static int findMax(int a,int b,int c){

        int help = Math.max(a,b);

        return Math.max(help,c);

    }

    public static int recursive_call(int[] a,int[][] memory, int i, int j){

        if(i>a.length-1 || j < 0 || i>j){
            return Integer.MIN_VALUE;
        }

        int sum = 0;

        if(memory[i][j] > Integer.MIN_VALUE){
            sum = memory[i][j];
        }else{
            sum = calculate_sum(a,i,j);
            memory[i][j] = sum;
        }

        int max = findMax(sum,recursive_call(a,memory,i+1,j),recursive_call(a,memory,i,j-1));

        return max;
    }

    public static int maxSumDp(int[] a){

        if(a.length == 1)
            return a[0];
        if(a == null && a.length == 0){
            return 0;
        }
        int[][] memory = initialize_memory(a);

        int max_value = recursive_call(a,memory,0,a.length-1);
        return max_value;
    }

    //since we have to only written the max sum we have use a greedy approach here in O(n)
    public static int maxSum(int[] a){
        int maxSoFar = 0, max = Integer.MIN_VALUE;
        for (int num : a) {
            if (maxSoFar < 0) {
                maxSoFar = num;
            } else {
                maxSoFar += num;
            }
            if (maxSoFar > max) {
                max = maxSoFar;
            }
        }
        return max;
    }

    //now

    public static void main(String[] args){
        int[] a = {-2,-1};

        System.out.print(maxSumDp(a));
    }
}
