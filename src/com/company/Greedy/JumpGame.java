package com.company.Greedy;

public class JumpGame {

    public static boolean canJump_helper2(int[] nums){
        if(nums[0] == 0 && nums.length >= 2)
            return false;

        int zero_counter = 0;

        for(int i=nums.length-2;i>=0;i--){

            if(nums[i] == 0){
                zero_counter = zero_counter + 1;
            }else{
                if(nums[i] > zero_counter){
                    zero_counter = 0;
                }else{
                    zero_counter = zero_counter + 1;
                }
            }
        }
        if(zero_counter == 0)
            return true;
        else
            return false;
    }

    //Recursive call runs 74/75 cases Dp solution
    public static boolean canJump_helper(int[] nums, int i,boolean[] jumper){

        if(jumper[i] == true)
            return true;

        int maxJump = nums[i];

        if(i == nums.length-1 || maxJump >= nums.length-1-i)
            return true;

        if(maxJump == 0) {
            return false;
        }

        for(int j=1;j<=maxJump;j++){
            jumper[i+j] = canJump_helper(nums,j+i,jumper);
            if(jumper[i+j])
                return true;
        }
        return false;
    }
    public static boolean canJump(int[] nums) {

        boolean[] jumper = new boolean[nums.length+1];

        //return canJump_helper(nums,0,jumper);

        return canJump_helper2(nums);

    }



    public static void main(String[] args){

        int[] nums = {3,0,8,2,0,0,1};


        System.out.print(canJump(nums));
    }
}
