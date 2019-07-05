package com.codegym.pms.repository;

import com.codegym.pms.model.Product;

import java.util.List;

public interface Repository <T>{

     void save(T model);

     List<T> findAll();

     T findById(Long id);

     void remove(Long id);

}
