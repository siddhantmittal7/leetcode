package com.company.General;

public class MaximumArea {

    public static int area;
    public static int max_area;

    public static int maxAreaOfIsland(int[][] grid) {

        int num = 2;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid,num,i,j);
                    num++;
                    if(area > max_area){
                        max_area = area;
                    }
                    area = 0;
                }
            }
        }

        return max_area;
    }

    public static void dfs(int[][] grid, int num, int i, int j){

        if(i>grid.length || j>grid[0].length || i<0 || j<0)
            return;

        grid[i][j] = num;

        area=area+1;

        if(i+1 < grid.length && grid[i+1][j] == 1){
            dfs(grid,num,i+1,j);
        }
        if(i-1 >= 0 && grid[i-1][j] == 1){
            dfs(grid,num,i-1,j);
        }
        if(j+1 < grid[0].length && grid[i][j+1] == 1){
            dfs(grid,num,i,j+1);
        }
        if(j-1>=0 && grid[i][j-1] == 1){
            dfs(grid,num,i,j-1);
        }

        return;
    }

    public static void main(String[] args){

        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
    {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));


    }
}
