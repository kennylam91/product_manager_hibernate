package com.codegym.pms.repository;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findAllByCategory(Category category);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
