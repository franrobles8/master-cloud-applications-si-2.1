package com.mastercloudapps.practica1.model;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Book {
    private String id;
    private String title;
    private String summary;
    private String author;
    private String publishingHouse;
    private int publicationYear;
    private ConcurrentMap<String, Comment> comments;

    public Book(String title, String summary, String author, String publishingHouse, int publicationYear) {
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publicationYear = publicationYear;
        this.comments = new ConcurrentHashMap<>();
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublishingHouse() {
        return this.publishingHouse;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Comment> getComments() {
        return this.comments.values();
    }

    public void addComment(Comment comment) {
        this.comments.put(comment.getId(), comment);
    }

    public void deleteComment(String commentId) {
        if (this.comments.containsKey(commentId))
            this.comments.remove(commentId);
    }
}
