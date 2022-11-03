package com.raiseup.springMVC.service;

import com.raiseup.springMVC.exception.BookNotFoundException;
import com.raiseup.springMVC.model.Book;
import com.raiseup.springMVC.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        Iterable<Book> all = bookRepository.findAll();
        List<Book>books= new ArrayList<>();
        all.forEach(books::add);
        return books;
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new BookNotFoundException("Book does not exists",null));
        return book;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Objects deleteBook(Long id) {
        bookRepository.deleteById(id);
        return null;
    }

    public Book updateBook(Book book) {
        Book findedBook = bookRepository.findById(book.getId()).get();
        findedBook.setAuthor(book.getAuthor());
        findedBook.setTitle(book.getTitle());
        return bookRepository.save(findedBook);
    }
}
