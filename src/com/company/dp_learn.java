package com.company;

public class dp_learn {

    //rod cutting problem

    public static void main(String[] args){

        int[] cost = {1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9,1,7,5,4,5,6,7,9};

        long startTime = System.currentTimeMillis();

        System.out.println(optimal_solution_recursive(cost,10));

        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime);

        startTime = System.currentTimeMillis();

        System.out.println(optimal_solution_mem(cost,10));

        stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime);


    }

    //using normal recursive function

    public static int optimal_solution_recursive(int[] cost, int n){
        if(n == 0)
            return 0;

        int sol = -1;

        for(int i=1;i<=n;i++){
            //System.out.println("Value of n: " + n + "," + (n-i) + "," + i);
            sol = Math.max(sol,cost[i-1] + optimal_solution_recursive(cost,n-i));
        }
        return sol;
    }

    public static int optimal_solution_mem(int[] cost, int n){
        int[] r = new int[n];

        int opt = optimal_solution_mem_helper(r,cost,n);

        return opt;


    }

    public static int optimal_solution_mem_helper(int[] r, int[] cost, int n){

        if(n > 0 && r[n-1] > 0)
            return r[n-1];

        int sol = -1;

        if(n == 0)
            sol = 0;
        else {
            for (int i = 1; i <= n; i++) {
                sol = Math.max(sol, cost[i - 1] + optimal_solution_mem_helper(r,cost, n - i));
            }
            r[n-1] = sol;
        }
        return sol;

    }
}
