package com.company.DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class SubarrayswithKDifferentIntegers {


    public static boolean isGoodArray(int[] A, int i, int j, int k){

        Set<Integer> s = new HashSet<Integer>();

        for(int m=i;m<=j;m++){
            s.add(A[m]);
        }

        if(s.size() == k){
            return true;
        }else{
            return false;
        }
    }

    public static void printArray(int[] A, int i, int  j){
        for(int m=i;m<=j;m++){
            System.out.print(A[m] + ",");
        }
        System.out.println();
    }

    public static int helper(int[][] c, int[][] visited, int k, int[] A, int i, int j){


        if(j-i < k-1 || i<0 || j>A.length-1 || i>j){
            return 0;
        }

        if(visited[i][j] > 0){
            return 0;
        }else{
            visited[i][j] = 1;
        }

        if(isGoodArray(A,i,j,k)){
            printArray(A,i,j);
            c[i][j] = helper(c,visited,k,A,i+1,j) + helper(c,visited,k,A,i,j-1) + 1;
        }else{
            c[i][j] = helper(c,visited,k,A,i+1,j) + helper(c,visited,k,A,i,j-1);
        }

        return c[i][j];
    }

    public static int subarraysWithKDistinct(int[] A, int K) {

        int[][] c = new int[A.length][A.length];
        int[][] a = new int[A.length][A.length];


        return helper(c,a,K,A,0,A.length-1);

//        int sum = 0;
//
//        for(int i=0;i<A.length;i++){
//            for(int j=0;j<A.length;j++){
//                if(isGoodArray(A,i,j,K)){
//                    sum = sum + 1;
//                }
//            }
//        }
//
//        return sum;
    }

    public static void main(String[] args){
        int[] A = {1,2,1,2,3};
        int K = 2;

        System.out.println(subarraysWithKDistinct(A,K));
    }
}
