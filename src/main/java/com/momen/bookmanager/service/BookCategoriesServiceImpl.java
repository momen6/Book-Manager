package com.momen.bookmanager.service;

import com.momen.bookmanager.exception.ResourceNotFoundException;
import com.momen.bookmanager.model.BookCategory;
import com.momen.bookmanager.repository.BookCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookCategoriesServiceImpl implements BookCategoriesService {

    private final BookCategoryRepository repository;

    @Override
    public List<BookCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public BookCategory findBookCategoryById(long id) {
        Optional<BookCategory> result = repository.findById(id);
        BookCategory bookCategory = null;
        if (result.isPresent()) bookCategory = result.get();
        else throw new ResourceNotFoundException("BookCategory", "ID", id);
        return bookCategory;
    }

    @Override
    public BookCategory saveBookCategory(BookCategory bookCategory) {
        return repository.save(bookCategory);
    }

    @Override
    public void deleteCategory(long id) {
        repository.deleteById(id);
    }
}
