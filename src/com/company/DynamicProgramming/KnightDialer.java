package com.company.DynamicProgramming;

public class KnightDialer {


    public static long helper(int N, long[][] c, int i, int[] a, int[][] b){

        if(i>9)
            return 0;

        if(N == 1)
            return 1;

        if(c[N][i] > 0){
            return c[N][i];
        }
        else{
            int[] validMoves = b[i];

            for(int k=0;k<validMoves.length;k++){
                c[N][i] = c[N][i] + helper(N-1,c,validMoves[k],a,b);
            }

            return c[N][i];
        }
    }

    public static int knightDialer(int N) {

        int[] a = {2,2,2,2,3,0,3,2,2,2};
        int[][] b = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{1,7,0},{2,6},{1,3},{2,4}};

        long[][] c = new long[N+1][10];


        for(int j=0;j<10;j++){
            c[N][j] = helper(N,c,j,a,b);
        }

        long sum =0;
        for(int j=0;j<10;j++){
            sum = sum + c[N][j];
            sum = sum%1000000007;
        }

        return (int) sum;
    }

    public static void main(String[] args){
        System.out.print(knightDialer(161));
    }
}
