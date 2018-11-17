package com.company.General;

public class SurroundedRegions {
    public void solve(char[][] board) {

        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(board[i][j] == 'O'){
                    if(board[i-1][j] == 'O' && i == 0)
                        break;
                    else if(board[i][j-1] == 'O' && j == 0)
                        break;
                    else if(board[i+1][j] == 'O' && i == board.length-1)
                        break;
                    else if(board[i][j+1] == 'O' && j == board[0].length-1)
                        break;
                    else{
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
