package com.company.Graph;

public class NumberOfIslands {

    public static void dfs_search(char[][] A, boolean[][] visited, int i, int j, int a){

        if(i>A.length || j>A[0].length || i<0 || j<0)
            return;

        if(visited[i][j] == true)
            return;

        if(A[i][j] == '1'){
            A[i][j] = (char)a;
            visited[i][j] = true;
        }

        if(i+1<A.length && A[i+1][j] == '1')
            dfs_search(A,visited,i+1,j,a);
        if(i-1>=0 && A[i-1][j] == '1')
            dfs_search(A,visited,i-1,j,a);
        if(j+1<A[0].length && A[i][j+1] == '1')
            dfs_search(A,visited,i,j+1,a);
        if(j-1>=0 && A[i][j-1] == '1')
            dfs_search(A,visited,i,j-1,a);

        return;

    }

    public static void print(char[][] A){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] == '0'){
                    System.out.print("#" + "        ");
                }else{
                    System.out.print(Integer.valueOf(A[i][j]) + "       ");
                }

            }
            System.out.println();
        }
    }

    public static int numIslands(char[][] A) {

        if(A.length == 0 || A == null){
            return 0;
        }

        boolean[][] visited = new boolean[A.length][A[0].length];
        int[][] c = new int[A.length][A[0].length];


        int a = 2;

        boolean emptyFlag = true;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == '1') {
                    emptyFlag = false;
                    dfs_search(A,visited, i, j, a);
                    a++;
                }
            }
        }

        a--;
        a--;

        print(A);

        if(emptyFlag){
            return 0;
        }else{
            return a;
        }
    }


    public static void main(String[] args){

        char[][] a = {
                {
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0'
                },
                {
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1'
                },
                {
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1'
                },
                {
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0'
                },
                {
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1',
                        '1',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0'
                },
                {
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0'
                },
                {
                        '1',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0'
                },
                {
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0'
                },
                {
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0'
                },
                {
                        '1',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0'
                },
                {
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0'
                },
                {
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0'
                },
                {
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0',
                        '0'
                },
                {
                        '1',
                        '0',
                        '0',
                        '0',
                        '0',
                        '1',
                        '0',
                        '0',
                        '0',
                        '1',
                        '1',
                        '0',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '1',
                        '0',
                        '0'
                }
        };

        System.out.print(numIslands(a));

    }
}
