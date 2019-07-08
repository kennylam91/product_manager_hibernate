package com.codegym.pms.service;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {
    void save(Product product);

    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void remove(Long id);

    Iterable<Product> findAllByCategory(Category category);


}
