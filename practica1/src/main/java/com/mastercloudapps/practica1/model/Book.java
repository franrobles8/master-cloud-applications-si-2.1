package com.mastercloudapps.practica1.model;

public class Book {
    private String id;
    private String title;
    private String summary;
    private String author;
    private String publishingHouse;
    private int publicationYear;

    public Book(String title, String summary, String author, String publishingHouse, int publicationYear) {
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publicationYear = publicationYear;
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
}
