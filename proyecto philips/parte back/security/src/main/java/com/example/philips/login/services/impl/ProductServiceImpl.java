package com.example.philips.login.services.impl;

import com.example.philips.login.entities.ProductEntity;
import com.example.philips.login.mappers.ProductMapper;
import com.example.philips.login.models.ProductDTO;
import com.example.philips.login.repositories.ProductRepository;
import com.example.philips.login.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductDTO productDTO) {
        return productRepository.save(ProductMapper.toEntity(productDTO));
    }

    @Override
    public ProductEntity getById(Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity uploadById(Long id, ProductDTO productDTO) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(RuntimeException::new);
        productEntity.setName(productDTO.name());
        productEntity.setDescription(productDTO.description());
        productEntity.setPrice(productDTO.price());
        productEntity.setStock(productDTO.stock());
        productEntity.setImagenUrl(productDTO.imagenUrl());
        return productRepository.save(productEntity);
    }


    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
