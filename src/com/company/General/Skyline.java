package com.company.General;

public class Skyline {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {


        int[] vertialSkyline = new int[grid.length];
        int[] horizontalSkyline = new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<grid[0].length;j++){
                int value = grid[i][j];
                if(value > max){
                    vertialSkyline[i] = value;
                    max = value;
                }
            }
        }

        for(int i=0;i<grid[0].length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<grid.length;j++){
                int value = grid[j][i];
                if(value > max){
                    horizontalSkyline[i] = value;
                    max = value;
                }
            }
        }

        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int value = grid[i][j];
                int ans = Math.min(vertialSkyline[i],horizontalSkyline[j]);
                sum = sum + ans - value;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};


        System.out.println(maxIncreaseKeepingSkyline(grid));
    }
}
