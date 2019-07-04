package com.codegym.pms.repository.impl;

import com.codegym.pms.model.Product;
import com.codegym.pms.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query=em.createQuery("select p from Product p",Product.class);
        return query.getResultList();
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Product product) {
        if (product.getId() != null) {
            em.merge(product);
        } else {
            em.persist(product);
        }

    }
}
