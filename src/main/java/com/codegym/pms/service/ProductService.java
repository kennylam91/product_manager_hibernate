package com.codegym.pms.service;

import com.codegym.pms.model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    Iterable<Product> findAll();

    Product findById(Long id);

    void remove(Long id);
}
