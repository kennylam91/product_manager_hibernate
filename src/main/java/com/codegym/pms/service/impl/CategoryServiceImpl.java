package com.codegym.pms.service.impl;

import com.codegym.pms.model.Category;
import com.codegym.pms.repository.CategoryRepository;
import com.codegym.pms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.delete(id);
    }
}
