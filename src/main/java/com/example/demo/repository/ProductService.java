package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<Product> findAll() {
        return new HashSet<>(productRepository.findAll());

    }

    public void add(Product product) {
        productRepository.add(product);
    }
}
