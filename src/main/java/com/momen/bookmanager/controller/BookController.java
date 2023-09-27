package com.momen.bookmanager.controller;

import com.momen.bookmanager.exception.ResourceNotFoundException;
import com.momen.bookmanager.model.Book;
import com.momen.bookmanager.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return new ResponseEntity<>(service.findBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book.setId(0L);
        return new ResponseEntity<>(service.addBook(book), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(service.addBook(book), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id){
        service.deleteBook(id);
        return new ResponseEntity<>("Book Deleted!",HttpStatus.OK);
    }
}
