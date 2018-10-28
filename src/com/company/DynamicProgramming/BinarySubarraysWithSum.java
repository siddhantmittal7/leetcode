package com.company.DynamicProgramming;

public class BinarySubarraysWithSum {


    public static int numSubarraysWithSum(int[] A, int S) {

        if(A.length == 0 || A == null){
            return 0;
        }

        int count = 0;
        for(int i=0;i<A.length;i++){
            int sum = 0;
            for(int j=i;j<A.length;j++){
                sum = sum + A[j];
                if(sum > S){
                    break;
                }
                if(sum == S)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[] A = {1,0,1,0,1};
        int S = 2;
        System.out.print(numSubarraysWithSum(A,S));
    }
}
