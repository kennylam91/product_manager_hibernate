package com.codegym.pms.formatter;

import com.codegym.pms.model.Category;
import com.codegym.pms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    public CategoryFormatter(CategoryService categoryService) {
        this.categoryService=categoryService;
    }


    @Autowired
    CategoryService categoryService;

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return object.getName();
    }
}
