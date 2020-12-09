package com.mastercloudapps.practica1.model.rest;

public class BookSummaryDto {
    
    private String id;
    private String title;

    public BookSummaryDto(String id, String title){
        this.id = id;
        this.title = title; 
    }
    
    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
