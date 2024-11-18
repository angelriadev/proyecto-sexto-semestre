package com.example.philips.login.services;


import com.example.philips.login.entities.ProductEntity;

import com.example.philips.login.models.ProductDTO;

import java.util.List;


public interface ProductService {
    ProductEntity save(ProductDTO productDTO);
    ProductEntity getById(Long id);
    List<ProductEntity> getAll();
    ProductEntity uploadById(Long id, ProductDTO productDTO);
    void deleteById(Long id);
}
