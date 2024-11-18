package com.example.philips.login.controllers;

import com.example.philips.login.entities.ProductEntity;
import com.example.philips.login.models.ProductDTO;
import com.example.philips.login.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/upload/{id}")
    public ResponseEntity<ProductEntity> uploadProductById(@PathVariable Long id, @RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.uploadById(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
    }
}
