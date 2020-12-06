package com.mastercloudapps.practica1.model;

public class Comment {
    private String id;
    private String name;
    private String value;
    private Score score;

    public Comment(String name, String value, double score) throws ScoreOutOfRangeException {
        this.name = name;
        this.value = value;
        this.score = new Score(score);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public Score getScore() {
        return this.score;
    }

    public void setId(String id) {
        this.id = id;
    }
}
