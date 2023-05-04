package com.example.demo;

public class DHighscore {

    private final String date;
    private final double bank;

    public DHighscore(String date, double score) {
        this.date = date;
        this.bank = score;
    }


    public String getDate() {
        return date;
    }

    public double getBank() {
        return bank;
    }
}
