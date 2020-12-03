package com.mastercloudapps.practica1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.mastercloudapps.practica1.model.Comment;

import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private ConcurrentMap<String, ConcurrentMap<String, Comment>> bookComments = new ConcurrentHashMap<>();

    public Collection<Comment> findAll(String bookId) {
        ConcurrentMap<String, Comment> comments = this.bookComments.get(bookId);
        if(comments == null) {
            return new ArrayList<>();
        }
        return comments.values();
    }

    public void add(String bookId, Comment comment) {
        ConcurrentMap<String, Comment> comments = this.bookComments.get(bookId);
        if(comments == null)
            comments = new ConcurrentHashMap<>();
        comments.put(comment.getId(), comment);
        this.bookComments.put(bookId, comments);
    }

    public void remove(String bookId, String commentId) {
        ConcurrentMap<String, Comment> comments = this.bookComments.get(bookId);
        if(comments != null) {
            comments.remove(commentId);
        }
    }
}
