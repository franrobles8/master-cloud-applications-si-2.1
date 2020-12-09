package com.mastercloudapps.practica1.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;
import com.mastercloudapps.practica1.model.Error;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class BooksService {
    private ConcurrentMap<String, Book> books = new ConcurrentHashMap<>();

    public BooksService() {
        this.add(new Book("The fellowship of the ring", "Summary example", "J.R.R. Tolkien", "HarperCollins", 2005));
        this.add(new Book("The Lord of the Rings: The two towers", "Summary example", "J.R.R. Tolkien", "HarperCollins",
                2002));
    }

    public String add(Book book) {
        String id = UUID.randomUUID().toString();
        book.setId(id);
        this.books.put(id, book);
        return id;
    }

    public Collection<Book> findAll() {
        return this.books.values();
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(this.books.get(id));    
    }

    public Collection<Comment> findAllComments(String id) {
        Book book = this.books.get(id);
        if(book != null) {
            return book.getComments();
        }
        return new ArrayList<>();
    }

    public boolean deleteBook(String id){
        if (this.books.containsKey(id)){
            this.books.remove(id);
            return true;
        }
        return false;
    }

    public String addComment(String id, Comment comment) {
        if(this.books.containsKey(id)){
            String commentId = UUID.randomUUID().toString();
            comment.setId(commentId);
            this.books.get(id).addComment(comment);
            return commentId;
        }
        return Error.BOOK_NOT_FOUND.toString();
    }

    public String deleteComment(String id, String commentId) {
        if(this.books.containsKey(id)){
            this.books.get(id).deleteComment(commentId);
            return commentId;
        }
        return Error.BOOK_NOT_FOUND.toString();
    }

    
}
