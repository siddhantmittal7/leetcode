package com.company.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestHarmoniousSubsequence {

    public static int findLHS(int[] nums) {
//        int[] hl = new int[nums.length+1];
//        hl[0] = 0;
//
//        int smallest = nums[0];
//        int largest = nums[0];
//
//        for(int i=1;i<nums.length;i++){
//            if(nums[i] <= largest && nums[i] >= smallest){
//                hl[i] = hl[i-1];
//            }else{
//                if(nums[i] > largest){
//                    if(nums[i] - smallest == 1) {
//                        hl[i] = hl[i - 1] + 1;
//                    }
//                    largest = nums[i];
//                }
//                if(nums[i] < smallest){
//                    if(largest - nums[i] == 1) {
//                            hl[i] = hl[i - 1] + 1;
//                    }
//                    smallest = nums[i];
//                }
//            }
//        }
//
//        return hl[nums.length-1];

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.remove(nums[i]);
                map.put(nums[i],value+1);
            }else{
                map.put(nums[i],1);
            }
        }

        Set<Integer> m = map.keySet();

        int max=0;

        for(Integer i: m){
            for(Integer j:m){
                if(Math.abs(i-j) == 1){
                    if(map.get(i) + map.get(j) > max){
                        max = map.get(i) + map.get(j);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args){

        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.print(findLHS(nums));
    }
}
