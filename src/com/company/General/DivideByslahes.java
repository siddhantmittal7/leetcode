package com.company.General;

public class DivideByslahes {

    public static int numIslands(char[][] grid) {
        int numOFislands = 0;
        int rows = grid.length;
        if(rows == 0) {
            return numOFislands;
        }
        int columns = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (grid[i][j] == '1') {
                    numOFislands++;
                    grid = BFS(grid, i, j);
                }
            }
        }
        return numOFislands;
    }

    public static char[][] BFS(char[][] grid, int i, int j) {
        grid[i][j] = 0;
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            grid = BFS(grid, i, j - 1);
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            grid = BFS(grid, i - 1, j);
        if (i + 1 < grid.length && grid[i + 1][j] == '1')
            grid = BFS(grid, i + 1, j);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
            grid = BFS(grid, i, j + 1);
        return grid;
    }

    public static boolean checkproperline(char[][] mat, int i, int j){
        if(i < 0 || j < 0 || i > mat.length-1 || j > mat.length-1){
            return false;
        }
        if(i == 0 || j == 0 || i == mat.length-1 || j == mat.length-1){
            return true;
        }

        if(mat[i][j] == '0'){
            return checkproperline(mat,i-1,j-1);
        }

        return false;
    }

    public static int regionsBySlashes(String[] grid) {

        char[][] mat = new char[grid.length*2][grid.length*2];

        for(int i=0;i<grid.length;i++){
            String s = grid[i];
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '\\'){
                    mat[2*i][2*j] = '0';
                    mat[2*i+1][2*j+1] = '0';
                    mat[2*i+1][2*j] = '1';
                    mat[2*i][2*j+1] = '1';
                    j++;
                }else if(s.charAt(j) == '/'){
                    mat[2*i][2*j] = '1';
                    mat[2*i+1][2*j+1] = '1';
                    mat[2*i+1][2*j] = '0';
                    mat[2*i][2*j+1] = '0';
                }else {
                    mat[2*i][2*j] = '1';
                    mat[2*i+1][2*j+1] = '1';
                    mat[2*i+1][2*j] = '1';
                    mat[2*i][2*j+1] = '1';
                }
            }
        }

        int parts = 0;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j] == '0'){
                    if(checkproperline(mat,i-1,j-1)){
                        parts++;
                    }
                    if(checkproperline(mat,i+1,j+1)){
                        parts++;
                    }
                }
            }
        }

        return parts;
    }



    public static void main(String[] args){

        String[] s = {   "/\\",
                "\\/"};

        System.out.println(regionsBySlashes(s));


    }
}
