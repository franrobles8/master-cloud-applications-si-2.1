package com.mastercloudapps.practica1.controller;

import com.mastercloudapps.practica1.model.Comment;
import com.mastercloudapps.practica1.service.BooksService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentsController {

    private BooksService booksService;
    
    public CommentsController(BooksService booksService) {
        this.booksService = booksService;
    }
    
    @PostMapping("/comments/{bookId}")
    public String comment(Model model, @PathVariable String bookId, Comment comment) {
        this.booksService.addComment(bookId, comment);
        return "redirect:/books/" + bookId;
    }
}
