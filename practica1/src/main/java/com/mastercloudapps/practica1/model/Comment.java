package com.mastercloudapps.practica1.model;

public class Comment {
    private String id;
    private String name;
    private String comment;
    private Score score;

    public Comment(String name, String comment, double score) {
        this.name = name;
        this.comment = comment;
        this.score = new Score(score);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getComment() {
        return this.comment;
    }

    public Score getScore() {
        return this.score;
    }

    public void setId(String id) {
        this.id = id;
    }
}
