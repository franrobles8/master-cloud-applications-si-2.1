package com.mastercloudapps.practica1.controller.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;
import com.mastercloudapps.practica1.model.Error;
import com.mastercloudapps.practica1.model.ScoreOutOfRangeException;
import com.mastercloudapps.practica1.model.rest.BookAndCommentsDto;
import com.mastercloudapps.practica1.model.rest.BookSummaryDto;
import com.mastercloudapps.practica1.model.rest.CommentsDto;
import com.mastercloudapps.practica1.service.BooksService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/books/")
public class ApiControllerImpl implements ApiController {

    private Logger log = LoggerFactory.getLogger(ApiController.class);

    private BooksService booksService;

    public ApiControllerImpl(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public ResponseEntity<List<BookSummaryDto>> getBooks() {
        log.info("getBooks method called");
        List<BookSummaryDto> books = new ArrayList<>();
        this.booksService.findAll().forEach(book -> books.add(new BookSummaryDto(book.getId(), book.getTitle())));
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @Override
    public ResponseEntity<BookAndCommentsDto> getBook(String id) {
        log.info("getBook method called");
        BookAndCommentsDto bookAndCooments = new BookAndCommentsDto();
        Optional<Book> book = this.booksService.findById(id);
        if (book.isPresent()) {
            bookAndCooments.setBook(book.get());
            this.booksService.findAllComments(id).forEach(comment -> bookAndCooments.addComment(comment));
            return ResponseEntity.status(HttpStatus.OK).body(bookAndCooments);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<String> postBook(Book book) {
        log.info("postBook method called");
        String id = booksService.add(book);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).body(id);
    }

    @Override
    public ResponseEntity<String> postComment(String id, CommentsDto comments) {
        log.info("postComment method called");

        if (this.booksService.findById(id).isPresent()) {
            String commentId;
            try {
                commentId = booksService.addComment(id,
                        new Comment(comments.getText(), comments.getUser(), comments.getScore()));
            } catch (ScoreOutOfRangeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

			URI location = fromCurrentRequest().path("/{id}")
						.buildAndExpand(commentId).toUri();
			return ResponseEntity.created(location).body(commentId);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }			
    }

    @Override
    public ResponseEntity<String> deleteComment(String id, String commentId) {
        log.info("deleteComment method called");
		String commentIdResponse = booksService.deleteComment(id, commentId);
		
		if (commentId != Error.BOOK_NOT_FOUND.toString()) {
			return ResponseEntity.ok(commentIdResponse);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}	
    
}
