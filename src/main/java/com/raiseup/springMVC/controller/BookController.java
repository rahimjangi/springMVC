package com.raiseup.springMVC.controller;

import com.raiseup.springMVC.exception.BookNotFoundException;
import com.raiseup.springMVC.model.Book;
import com.raiseup.springMVC.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>>getBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/title/{bookTitle}")
    public ResponseEntity<List<Book>>getBooksByTitle(@PathVariable("bookTitle")String  bookTitle){
        return new ResponseEntity<>(bookService.findByTitle(bookTitle),HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book>getBookById(@PathVariable("bookId")Long bookId) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.getBookById(bookId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book>create(@RequestBody Book book){
        return new ResponseEntity<>(bookService.createBook(book),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id")Long id){
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book>updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.ACCEPTED);
    }
}
