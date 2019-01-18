package com.company.DynamicProgramming;

public class CombinationSumIV {

//    public static int helper(int[][] c, int[] nums, int target, int i){
//
//        if(target == 0)
//            return 1;
//
//        if(target < 0){
//            return 0;
//        }
//
//        if(i<0){
//            return 0;
//        }
//
//        if(c[i][target] > 0)
//            return c[i][target];
//
//        for(int j=i;j>=0;j--){
//            c[j][target] = helper(c,nums,target-nums[j],j) + helper(c,nums,target,j-1);
//        }
//
//        return c[i][target];
//    }

    public static int helper2(int[] c, int[] nums, int target){

        if(target<0)
            return 0;

        if(target==0)
            return 1;

        if(c[target] > 0){
            return c[target];
        }


        for(int i=0;i<nums.length;i++){
            c[target] = c[target] + helper2(c,nums,target-nums[i]);
        }

        return c[target];
    }



    public static int combinationSum4(int[] nums, int target) {

        if(nums == null && nums.length == 0)
            return 0;


        int[] c = new int[target+1];

        helper2(c,nums,target);

        return c[target];


    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums,target));
    }
}
