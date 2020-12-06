package com.mastercloudapps.practica1.model;

public class Score {
    protected static final double MAX_SCORE = 5.0;
    protected static final double MIN_SCORE = 0.0;
    private double value;

    public Score(double value) throws ScoreOutOfRangeException {
        this.setValue(value);
    }

    public double getValue() {
        return this.value;
    }

    private void setValue(double value) throws ScoreOutOfRangeException {
        if(!(value >= MIN_SCORE && value <= MAX_SCORE))
            throw new ScoreOutOfRangeException();
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
