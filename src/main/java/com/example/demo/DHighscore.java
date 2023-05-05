package com.example.demo;

public class DHighscore {

    private final String date;
    private final Double score;

    protected DHighscore(String date, Double score) {
        this.date = date;
        this.score = score;
    }


    public String getDate() {
        return date;
    }

    public Double getScore() {
        return score;
    }
}
