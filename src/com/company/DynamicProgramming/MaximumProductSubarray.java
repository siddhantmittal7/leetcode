package com.company.DynamicProgramming;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {

        if(nums.length == 0)
            return 0;

        int maxsofar = nums[0];
        int max = nums[0];

        int k = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                k=i;
                break;
            }
        }
        maxsofar = nums[k];
        max = nums[k];

        for(int i=k+1;i<nums.length;i++){
            max = max*nums[i];
            if(max > maxsofar)
                maxsofar = max;
        }

        return maxsofar;
    }

    public static void main(String[] args){
        int[] a = {0,4};
        System.out.print(maxProduct(a));
    }
}
