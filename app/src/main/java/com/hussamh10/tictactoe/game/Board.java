package com.hussamh10.tictactoe.game;

public class Board{
    private int [][] board;
    private int move;
    private int len;

    public Board(){
        move = 1;
        len = 3;
        board = new int[len][len];

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                board[i][j] = 0;
            }
        }
    }

    public int player(){
        return move;
    }

    public int[][] getBoard(){
        return board;
    }

    public void makeMove(int r, int c){
        if (board[r][c] == 0){
            board[r][c] = move;
        }
        nextMove();
    }

    public int hasWon(){
        int winner = 0;
        winner = checkHorizontal();
        if (winner > 0){
            return winner;
        }
        winner = checkVertical();
        if (winner > 0){
            return winner;
        }
        winner = checkDiagonal();
        return winner;
    }

    public Move[] getAvailableMoves(){
        int c = 0;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (board[i][j] == 0){
                    c++;
                }
            }
        }

        Move [] moves = new Move[c];
        int k = 0;

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (board[i][j] == 0){
                    moves[k] = new Move(i, j);
                    k++;
                }
            }
        }
        return moves;
    }

    public Board getCopy(){
        Board temp = new Board();

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                temp.board[i][j] = board[i][j];
            }
        }

        temp.move = move;

        return temp;
    }

    private void nextMove(){
        if (move == 1){
            move = 2;
        }
        else{
            move = 1;
        }
    }

    private int checkDiagonal(){
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return board[0][2];
        }
        return 0;
    }

    private int checkHorizontal(){
        for (int i = 0; i < len; i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return board[i][0];
            }
        }
        return 0;
    }

    private int checkVertical(){
        for (int i = 0; i < len; i++){
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return board[0][i];
            }
        }
        return 0;
    }
}
