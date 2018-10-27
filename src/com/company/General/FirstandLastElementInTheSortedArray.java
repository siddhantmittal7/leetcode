package com.company.General;

public class FirstandLastElementInTheSortedArray {
    public static int[] searchRange(int[] nums, int target) {

        int[] out = new int[2];

        int lastindex = -1;
        int firstindex = -1;

        if(nums.length == 0 || nums == null){

        }else if(nums.length == 1){
            if(nums[0] == target){
                lastindex = 0;
                firstindex = 0;
            }
        }else if(nums[0] == nums[nums.length-1]){
            if(nums[0] == target){
                firstindex = 0;
                lastindex = nums.length-1;
            }
        }
        else{
            int lo = 0;
            int hi = nums.length-1;


            while(lo<hi){
                int mid = (hi+lo)/2;
                if(nums[mid] > target){
                    hi =  mid;
                    if(hi == nums.length-1)
                        break;
                }else if(nums[mid] < target){
                    lo = mid+1;
                    if(lo==0){
                        break;
                    }
                }else{
                    lastindex = mid;
                    firstindex = mid;
                    for(int i=mid;i<=hi;i++){
                        if(nums[i] == target){
                            lastindex = i;
                        }
                    }
                    for(int i=mid;i>=0;i--){
                        if(nums[i] == target){
                            firstindex = i;
                        }
                    }
                    break;
                }
            }

        }



        out[0] = firstindex;
        out[1] = lastindex;

        return out;


    }

    public static void main(String[] args){

        int a[] = {1,4};
        int[] out = searchRange(a,4);

        System.out.print(out[0] + " " + out[1]);
    }


}
