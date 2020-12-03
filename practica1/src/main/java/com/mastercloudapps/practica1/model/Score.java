package com.mastercloudapps.practica1.model;

public class Score {
    private static final double MAX_SCORE = 5.0;
    private static final double MIN_SCORE = 0.0;
    private double value;

    public Score(double value) {
        if(value >= MIN_SCORE && value <= MAX_SCORE)
            this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
