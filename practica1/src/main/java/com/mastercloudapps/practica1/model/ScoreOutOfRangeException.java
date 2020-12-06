package com.mastercloudapps.practica1.model;

public class ScoreOutOfRangeException extends Exception {
    private static final long serialVersionUID = -8522748778608606118L;

    ScoreOutOfRangeException() {
        super("Score must be between " + Score.MIN_SCORE + " and " + Score.MAX_SCORE);
    }
}
