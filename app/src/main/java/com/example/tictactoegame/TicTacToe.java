package com.example.tictactoegame;

import android.util.Log;

public class TicTacToe {

    private int[][] game;
    private enum mark {X_MOVE, O_MOVE, X_WIN, O_WIN, TIE}
    private mark turn;

    public static final int gameRows = 3;
    public static final int gameCols = 3;

    private static final int empty = 0;
    private static final int xPlay = 1;
    private static final int oPlay = 2;


    public TicTacToe() {
        newGame();
    }
    public void newGame() {
        game = new int[gameRows][gameCols];
        this.turn = mark.X_MOVE;
    }

    public void buttonPressed(int row, int col) {
        if(this.game[row][col] != empty)
            return;
        if(this.turn == mark.X_MOVE)
        {
            this.game[row][col] = xPlay;
            this.turn = mark.O_MOVE;
        }
        else if (this.turn ==  mark.O_MOVE)
        {
            this.game[row][col] = oPlay;
            this.turn = mark.X_MOVE;
        }
        checkForWin();
    }
    private void checkForWin() {
        if (!(this.turn == mark.X_MOVE || this.turn == mark.O_MOVE))
            return;
        if (pieceCheck(xPlay)) {
            this.turn = mark.X_WIN;
        }
        else if (pieceCheck(oPlay)) {
            this.turn = mark.O_WIN;
        }
        else if (isBoardFull()) {
            this.turn = mark.TIE;
        }
    }
    private boolean isBoardFull() {
        for (int i = 0 ; i < gameRows ; i++) {
            for (int j = 0 ; j < gameCols ; j++) {
                if (this.game[i][j] == empty) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean pieceCheck(int marker) {
        boolean check = true;
        for (int j = 0 ; j < gameCols ; j++) {
            check = true;
            for (int i = 0 ; i < gameRows ; i++) {
                if (this.game[i][j] != marker) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }
        for (int i = 0 ; i < gameRows ; i++) {
            check = true;
            for (int j = 0 ; j < gameCols ; j++) {
                if (this.game[i][j] != marker) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }

        if (this.game[0][0] == marker && this.game[1][1] == marker && this.game[2][2] == marker)
            return true;

        if (this.game[2][0] == marker && this.game[1][1] == marker && this.game[0][2] == marker)
            return true;

        return false;
    }
    public String setButton(int row, int column) {
        String Game = "";
        if (row >= 0 && row < gameRows && column >= 0
                && column < gameCols) {
            if (this.game[row][column] == xPlay) {
                return "X";
            } else if (this.game[row][column] == oPlay) {
                return "O";
            }
        }
        return Game;
    }


}
