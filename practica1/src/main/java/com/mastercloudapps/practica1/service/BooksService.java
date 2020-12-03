package com.mastercloudapps.practica1.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class BooksService {
    private ConcurrentMap<String, Book> books = new ConcurrentHashMap<>();

    public BooksService() {
        this.add(new Book("The fellowship of the ring", "Summary example", "J.R.R. Tolkien", "HarperCollins", 2005));
        this.add(new Book("The Lord of the Rings: The two towers", "Summary example", "J.R.R. Tolkien", "HarperCollins", 2002));
    }

    public void add(Book book) {
        String id = UUID.randomUUID().toString();
        book.setId(id);
        this.books.put(id, book);
    }

    public Collection<Book> findAll() {
        return this.books.values();
    }

    public Book findBookById(String id) {
        return this.books.get(id);
    }

    public void addComment(String id, Comment comment) {
        Book book = this.books.get(id);
        String commentId = UUID.randomUUID().toString();
        comment.setId(commentId);
        book.addComment(comment);
    }
}
