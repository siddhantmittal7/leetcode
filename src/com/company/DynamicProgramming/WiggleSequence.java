package com.company.DynamicProgramming;

import java.util.Arrays;

public class WiggleSequence {

    public static int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1 ){
            return 1;
        }

        if(nums.length == 2 ){
            if( nums[0] != nums[1]){
                return 2;
            }else{
                return 1;
            }
        }

        int[] l = new int[nums.length];

        int[] sign = new int[nums.length];

        int sum = 0;

        l[0] = 1;

        sign[0] = 0;


        for(int i=1;i<nums.length;i++){

            int max = 0;
            for(int j=0;j<i;j++){
                int diff = nums[i] - nums[j];
                if(sign[j] == 0){
                    if(diff > 0){
                        sign[i] = 1;
                        max = l[j];
                    }else if(diff < 0){
                        sign[i] = -1;
                        max = l[j];
                    }else{
                        sign[i] = 0;
                    }
                }else{
                    if(l[j] > max && diff*sign[j] < 0){
                        max = l[j];
                        if(diff > 0){
                            sign[i] = 1;
                        }else{
                            sign[i] = -1;
                        }
                    }
                }
            }
            l[i] = max + 1;
        }

        Arrays.sort(l);
        return l[nums.length-1];
    }

    public static void main(String[] args){
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
