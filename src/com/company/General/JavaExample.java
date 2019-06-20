package com.company.General;

class JavaExample{
    public static int[] getLargerst(int[] arr, int num){
        int[] ans = new int[2];
        if(arr == null || arr.length == 0){
            return ans;
        }

        int low = 0;
        int high = arr.length-1;
        int middle = 0;

        while(low < high){
            if(high - low == 1){
                if(arr[low] < num){
                    ans[0] = arr[low];
                    break;
                }else{
                    return ans;
                }
            }
            middle = (low + high)/2;
            //System.out.println(middle);
            if(arr[middle] == num){
                ans[0] = arr[middle-1];
                break;
            }else if(arr[middle] < num ){
                low = middle;
            }else{
                high = middle;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {7,8,9,10,11,12,15,18};
        int num = 6;
        int[] ans = getLargerst(arr,num);
        if(ans.length > 0)
            System.out.println(ans[0]);
        else
            System.out.println("no solution exit");
    }
}