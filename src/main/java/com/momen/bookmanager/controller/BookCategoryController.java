package com.momen.bookmanager.controller;

import com.momen.bookmanager.model.BookCategory;
import com.momen.bookmanager.service.BookCategoriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookCategories")
@RequiredArgsConstructor
public class BookCategoryController {
    private final BookCategoriesServiceImpl service;

    @GetMapping
    public ResponseEntity<List<BookCategory>> getAllCategories() {
        return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCategory> getCategoryByID(@PathVariable Long id){
        return new ResponseEntity<>(service.findBookCategoryById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BookCategory> addNewCategory(@RequestBody BookCategory bookCategory){
        bookCategory.setId(0L);
        return new ResponseEntity<>(service.saveBookCategory(bookCategory),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<BookCategory> updateCategory(@RequestBody BookCategory bookCategory){
        return new ResponseEntity<>(service.saveBookCategory(bookCategory),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable Long id){
        service.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
