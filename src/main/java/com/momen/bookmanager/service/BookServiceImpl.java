package com.momen.bookmanager.service;

import com.momen.bookmanager.exception.ResourceNotFoundException;
import com.momen.bookmanager.model.Book;
import com.momen.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(long id) {
        Optional<Book> result = bookRepository.findById(id);
        Book book = null;
        if (result.isPresent()) book = result.get();
        else throw new ResourceNotFoundException("Book", "ID", id);
        return book;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
