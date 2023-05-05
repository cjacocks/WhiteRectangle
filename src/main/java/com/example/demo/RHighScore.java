package com.example.demo;

public class RHighScore {
    private final String date;
    private final Integer turnCount;
    private final Integer playerScore;
    private final Integer adversaryScore;

    protected RHighScore(String date, Integer turnCount, Integer playerScore, Integer adversaryScore) {
        this.date = date;
        this.turnCount = turnCount;
        this.playerScore = playerScore;
        this.adversaryScore = adversaryScore;
    }


    public String getDate() {
        return date;
    }

    public Integer getTurnCount() {
        return turnCount;
    }

    public Integer getPlayerScore() {
        return playerScore;
    }

    public Integer getAdversaryScore() {
        return adversaryScore;
    }
}
