package com.company.DynamicProgramming;

public class shortestBridge {


    public static int shortHelper(int[][] A, int i, int j, int[][]c){

        if(i>=A.length || j>=A.length)
            return 0;

        if(c[i][j] > 0){
            return c[i][j];
        }

        if(A[i][j] == 1)
            return 0;
        else{
            if(i<A.length){
                c[i][j] = 1 + shortHelper(A,i,j+1,c);
            }else if (j<A.length){
                c[i][j] = 1 + shortHelper(A,i+1,j,c);
            }else{
                c[i][j] = 1 + Math.min(shortHelper(A,i+1,j,c),shortHelper(A,i,j+1,c));
            }

        }

        return c[i][j];
    }

    public static int shortestBridge(int[][] A) {

        int[][] c = new int[A.length+1][A.length+1];


        int i_i = 0;
        int i_j = 0;

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(A[i][j] == 1){
                    i_i = i;
                    i_j = j;
                    return shortHelper(A,i,j,c);
                }
            }
        }

        for(int i=i_i;i<A.length;i++){
            for(int j=i_j;j<A.length;j++){
                if(A[i][j] == 0){
                    return shortHelper(A,i,j,c);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args){

    }
}
