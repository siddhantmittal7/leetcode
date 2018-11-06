package com.company.General;

import java.util.*;

public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        int initial_i=0;

        if(nums[0] == 0){
            for(int i=1;i<nums.length;i++){
                if(nums[i] != 0){
                    initial_i = i;
                    break;
                }
            }
        }


        for(int k=initial_i+1;k<nums.length-1;k++){
            int i=initial_i;
            int j=nums.length-1;
            while(true){
                if(i==k || j==k || i>=nums.length || j<0){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(nums[k]);
                    Collections.sort(sol);
                    if(!ans.contains(sol))
                        ans.add(sol);
                    i++;
                    j--;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    j--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    i++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] strs = {3,0,-2,-1,1,2};
        System.out.println(threeSum(strs));
    }
}
