package com.company.Graph;

public class shortestBridge {


    public static int find_min(int d1, int d2, int d3, int d4){
        int min = d2;
        if(d2<min)
            min = d2;
        if(d3<min)
            min = d3;
        if(d4<min)
            min = d4;

        return min;
    }
    public static int shortHelper(int[][] A, int i, int j, int[][]c){

        if(i>=A.length || j>=A[0].length)
            return 0;

        if(c[i][j] < Integer.MAX_VALUE){
            return c[i][j];
        }

        int d1 = Integer.MAX_VALUE;
        int d2 = Integer.MAX_VALUE;
        int d3 = Integer.MAX_VALUE;
        int d4 = Integer.MAX_VALUE;

        if(A[i][j] == 3)
            return 0;
        else{
            if(j+1<A[0].length && A[i][j+1] == 0){
                d1 = 1 + shortHelper(A,i,j+1,c);
            }
            if (i+1<A.length && A[i+1][j] == 0){
                d2 = 1 + shortHelper(A,i+1,j,c);
            }
            if (i-1>=0 && A[i-1][j] == 0){
                d3 = 1 + shortHelper(A,i+1,j,c);
            }
            if (j-1>=0 && A[i][j-1] == 0){
                d3 = 1 + shortHelper(A,i+1,j,c);
            }else{
                return 0;
            }

            c[i][j] = find_min(d1,d2,d3,d4);
        }

        return c[i][j];
    }

    public static int shortestBridge(int[][] A) {

        return find_connected_components(A);
    }

    public static void dfs_search(int[][] A, int[][] B, int i, int j, int a){

        if(i>A.length || j>A[0].length || i<0 || j<0)
            return;

        if(B[i][j] > 0)
            return;

        if(A[i][j] == 1){
            B[i][j] = a;
        }

        if(i+1<A.length && A[i+1][j] == 1)
            dfs_search(A,B,i+1,j,a);
        if(i-1>=0 && A[i-1][j] == 1)
            dfs_search(A,B,i-1,j,a);
        if(j+1<A[0].length && A[i][j+1] == 1)
            dfs_search(A,B,i,j+1,a);
        if(j-1>=0 && A[i][j-1] == 1)
            dfs_search(A,B,i,j-1,a);

        return;

    }


    public static int find_connected_components(int[][] A){

        int[][] islands = new int[A.length][A[0].length];
        int[][] c = new int[A.length][A[0].length];

        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                c[i][j] = Integer.MAX_VALUE;
            }
        }

        int a=2;

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1){
                    dfs_search(A,islands,i,j,a);
                    a++;
                    break;
                }
            }
        }

        for(int i=0;i<islands.length;i++){
            for(int j=0;j<islands[0].length;j++){
                if(islands[i][j] == 2){
                    return shortHelper(islands,i,j,c);
                }
            }
        }


        return 0;

    }

    public static void main(String[] args){

        //int[][] a = {{0,1,0},{0,0,0},{0,0,1}};
        int[][] a = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};

        System.out.print(shortestBridge(a));

    }
}
