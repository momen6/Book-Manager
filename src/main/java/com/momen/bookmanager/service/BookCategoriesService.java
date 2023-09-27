package com.momen.bookmanager.service;

import com.momen.bookmanager.model.BookCategory;

import java.util.List;

public interface BookCategoriesService {

    List<BookCategory> getAllCategories();

    BookCategory findBookCategoryById(long id);

    BookCategory saveBookCategory(BookCategory bookCategory);

    void deleteCategory(long id);
}
