package com.mastercloudapps.practica1.controller;

import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", this.booksService.findAll());
        return "index";
    }

    @GetMapping("/books/{id}")
    public String book(Model model, @PathVariable String id) {
        Book book = this.booksService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("comments", book.getComments());
        return "book";
    }

    @PostMapping("/books")
    public String book(Model model, Book book) {
        this.booksService.add(book);
        return "redirect:/";
    }
}