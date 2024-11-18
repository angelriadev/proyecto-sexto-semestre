package com.example.philips.login.mappers;

import com.example.philips.login.entities.ProductEntity;
import com.example.philips.login.models.ProductDTO;

public class ProductMapper {
    public static ProductEntity toEntity(ProductDTO productDTO){
        return new ProductEntity(productDTO.name(), productDTO.description(), productDTO.price(),productDTO.stock(),productDTO.imagenUrl());
    }
}
