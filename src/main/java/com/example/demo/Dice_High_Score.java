package com.example.demo;

public class Dice_High_Score {

    private final String date;
    private final Double score;

    protected Dice_High_Score(String date, Double score) {
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
