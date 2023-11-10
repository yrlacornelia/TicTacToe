package com.example.tictactoe;

public class Player {
    private final String player;
    private int score;
    public Player(String player) {
        this.player = player;
        this.score = 0;
    }
    public void setScore(int points) {
        score = score + points;
    }
    public String getPlayer() {
        return player;
    }
    public int getScore() {
        return score;
    }

}
