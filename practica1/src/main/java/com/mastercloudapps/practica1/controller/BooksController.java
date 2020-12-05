package com.mastercloudapps.practica1.controller;

import javax.servlet.http.HttpSession;
import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;
import com.mastercloudapps.practica1.model.User;
import com.mastercloudapps.practica1.service.BooksService;
import com.mastercloudapps.utils.ScoreRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BooksController {

    private Logger log = LoggerFactory.getLogger(BooksController.class);
    private BooksService booksService;
    private User user;

    public BooksController(BooksService booksService, User user) {
        this.booksService = booksService;
        this.user = user;
    }

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if(session.isNew()) {
            session.invalidate();
        }
        model.addAttribute("books", this.booksService.findAll());
        return "index";
    }

    @GetMapping("/books/{id}")
    public String book(HttpSession session, Model model, @PathVariable String id) {
        model.addAttribute("book", this.booksService.findBookById(id));
        model.addAttribute("comments", this.booksService.findAllComments(id));
        model.addAttribute("commentName", this.user.getName());
        return "book";
    }

    @PostMapping("/books")
    public String books(Model model, Book book) {
        this.booksService.add(book);
        return "redirect:/";
    }

    @PostMapping("/books/{id}/comments")
    public String addComment(Model model, @PathVariable String id, Comment comment) {
        this.user.setName(comment.getName());
        if(!ScoreRange.inRange(comment.getScore().getValue()))
            log.warn("Score is out of the valid range [0-5]");
        this.booksService.addComment(id, comment);
        return "redirect:/books/" + id;
    }

    @PostMapping("/books/{id}/comments/{commentId}/")
    public String removeComment(Model model, @PathVariable String id, @PathVariable String commentId, @RequestParam boolean remove) {
        if(remove) {
            this.booksService.removeComment(id, commentId);
        }
        return "redirect:/books/" + id;
    }
}