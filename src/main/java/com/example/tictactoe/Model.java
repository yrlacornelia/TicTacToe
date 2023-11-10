package com.example.tictactoe;

import java.util.Objects;

public class Model {
    public String[][] board;
    public Player player1 = new Player("x");
    public Player player2 = new Player("o");
    public String currentPlayer = player1.getPlayer();


    public Model() {
        initializeBoard();
    }
    public void initializeBoard() {
        board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }
    public String[][] getBoard() {
        return board;
    }
    public void setBoard(String[][] board) {
        this.board = board;
    }
    public void setABoardPosition(int row, int col, String value) {
            if(isValidMove(row,col)) {
                board[row][col] = value;
            }
    }
    public boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }
    public String getABoardPosition(int row, int col) {
        return board[row][col];
    }

    public boolean checkWinner() {
        if (hasWon(player1.getPlayer())) {
            player1.setScore(1);
            return true;
        }
        else if (hasWon(player2.getPlayer())) {
            player2.setScore(1);
            return true;
        }
        else return isBoardFull();
    }
    public boolean hasWon(String player) {

        for (int i = 0; i < 3; i++) {
          if (player.equals(board[i][0] ) && player.equals(board[i][1]) && player.equals(board[i][2]))
              return true;
            if (player.equals(board[0][i]) && player.equals(board[1][i]) && player.equals(board[2][i]))
                return true;
        }
        if (player.equals(board[0][0]) && player.equals(board[1][1]) && player.equals(board[2][2]))
            return true;

        if (player.equals(board[0][2]) && player.equals(board[1][1]) && player.equals(board[2][0]))
            return true;

        return false;
    }
    boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!"x".equals(board[i][j]) && !"o".equals(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void toggleCurrentPlayer() {
        currentPlayer = (Objects.equals(currentPlayer, player1.getPlayer())) ? player2.getPlayer() : player1.getPlayer();
    }

}


