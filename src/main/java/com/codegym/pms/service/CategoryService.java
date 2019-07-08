package com.codegym.pms.service;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;

public interface CategoryService {
    void save(Category product);

    Iterable<Category> findAll();

    Category findById(Long id);

    void remove(Long id);

}
