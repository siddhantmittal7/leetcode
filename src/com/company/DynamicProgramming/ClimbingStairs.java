package com.company.DynamicProgramming;

public class ClimbingStairs {

    public static int numWays(int a, int[] r){
        if(a == 0)
            return 0;
        if(a == 1)
            return 1;
        if(a == 2)
            return 2;
        if(r[a-1] > 0)
            return r[a-1];

        r[a-1] = numWays(a-1,r) + numWays(a-2,r);

        return r[a-1];
    }

    public static int climbStairs(int n) {

        int[] r = new int[n];

        return numWays(n,r);
    }
    public static void main(String[] args){
        int value = 4;

        System.out.print(climbStairs(value));
    }
}
