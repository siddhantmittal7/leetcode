package com.company.General;

public class MinimumSizeSubarraySum {


    public static int minSubArrayLen(int s, int[] nums) {

        if(nums.length == 0 || nums == null)
            return 0;

        int sum =0;int min = Integer.MAX_VALUE;int j=0;

        for(int i=0;i<nums.length;i++){

            sum = sum + nums[i];

            while(sum >= s){
                if(i-j < min){
                    min = i-j;
                }

                sum = sum - nums[j];
                j++;
            }
        }

        if(min == Integer.MAX_VALUE)
            return 0;
        else
            return min+1;
    }

    public static void main(String[] args){
        int nums[] = {2,3,1,2,4};

        int s = 7;

        System.out.print(minSubArrayLen(s,nums));
    }
}
