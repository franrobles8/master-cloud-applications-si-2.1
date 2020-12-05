package com.mastercloudapps.utils;

public final class ScoreRange {
    private static final double MAX_SCORE = 5.0;
    private static final double MIN_SCORE = 0.0;

    private ScoreRange(){}

    public static boolean inRange(double value) {
        return value >= MIN_SCORE && value <= MAX_SCORE;
    }
}
