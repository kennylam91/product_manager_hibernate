package com.codegym.pms.service.impl;

import com.codegym.pms.model.Product;
import com.codegym.pms.repository.ProductRepository;
import com.codegym.pms.repository.impl.ProductRepositoryImpl;
import com.codegym.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }
}