package com.mastercloudapps.practica1.model.rest;

import java.util.ArrayList;
import java.util.List;

import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;

public class BookAndCommentsDto {

    private Book book;
	
    private List<Comment> comments;

    public BookAndCommentsDto(){
        this.comments = new ArrayList<>();
    }

    public BookAndCommentsDto(Book book, List<Comment> comments){
        this.book = book;
        this.comments = comments;
    }
    
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    /**
     * @return Book return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return List<Comment> return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
