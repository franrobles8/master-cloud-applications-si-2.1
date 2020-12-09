package com.mastercloudapps.practica1.controller.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mastercloudapps.practica1.model.Book;
import com.mastercloudapps.practica1.model.Comment;
import com.mastercloudapps.practica1.model.rest.BookAndCommentsDto;
import com.mastercloudapps.practica1.model.rest.BookSummaryDto;
import com.mastercloudapps.practica1.model.rest.CommentsDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "book")
public interface ApiController {
	
	@Operation(
			summary = "Find all books in the system", 
			description = "Find all books in the system", 
			tags = { "book" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookSummaryDto.class)))),
        @ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping(value="/")
	public ResponseEntity<List<BookSummaryDto>> getBooks();

	@Operation(
			summary = "Get the information of a specific book and its comments", 
			description = "Get the information of a specific book and its comments", 
			tags = { "book" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookAndCommentsDto.class)))),
        @ApiResponse(responseCode = "404", description = "Book not found") })
	@GetMapping(value="/{id}")
	public ResponseEntity<BookAndCommentsDto> getBook(@PathVariable(value="id") String id);
	
	@Operation(
			summary = "Add a new book", 
			description = "Add a new book", 
			tags = { "book" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Book successfully created",
                content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping(value="/")
	public ResponseEntity<String> postBook(@RequestBody Book book);
	
	@Operation(
			summary = "Add a new comment to a book", 
			description = "Add a new comment to a book", 
			tags = { "book" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Comment successfully created",
                content = @Content(schema = @Schema(implementation = Comment.class))),
		@ApiResponse(responseCode = "400", description = "Bad request"),
		@ApiResponse(responseCode = "404", description = "Book not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error") })
	@PostMapping(value="/{id}/comments")
	public ResponseEntity<String> postComment(@PathVariable(value="id") String id,
			@RequestBody CommentsDto comments);
	
	@Operation(
			summary = "Deletes a comment for a specific book", 
			description = "Deletes a comment for a specific book", 
			tags = { "book" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Comment successfully deleted",
        		content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Comment not found") })
	@DeleteMapping(value="/{id}/comments/{commentId}")
	public ResponseEntity<String> deleteComment(
			@PathVariable(value="id") String id, 
			@PathVariable(value="commentId") String commentId);

}