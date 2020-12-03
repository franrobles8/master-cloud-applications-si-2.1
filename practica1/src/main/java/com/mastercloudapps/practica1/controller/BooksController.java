package com.mastercloudapps.practica1.controller;

import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;
import com.mastercloudapps.practica1.service.BooksService;
import com.mastercloudapps.practica1.service.CommentsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {

    private BooksService booksService;
    private CommentsService commentsService;

    public BooksController(BooksService booksService, CommentsService commentsService) {
        this.booksService = booksService;
        this.commentsService = commentsService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", this.booksService.findAll());
        return "index";
    }

    @GetMapping("/books/{id}")
    public String book(Model model, @PathVariable String id) {
        model.addAttribute("book", this.booksService.findBookById(id));
        model.addAttribute("comments", commentsService.findAll(id));
        return "book";
    }

    @PostMapping("/books")
    public String books(Model model, Book book) {
        this.booksService.add(book);
        return "redirect:/";
    }

    @PostMapping("/books/{id}/comments")
    public String bookComment(Model model, @PathVariable String id, Comment comment) {
        this.commentsService.add(id, comment);
        return "redirect:/books/" + id;
    }
}