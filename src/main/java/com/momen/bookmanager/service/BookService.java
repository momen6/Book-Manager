package com.momen.bookmanager.service;

import com.momen.bookmanager.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book findBookById(long id);
    Book addBook(Book book);
    void deleteBook(long id);
}
