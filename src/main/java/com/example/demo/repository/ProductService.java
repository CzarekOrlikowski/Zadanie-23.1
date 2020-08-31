package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


    public double showTotalPrice (Set<Product> products){
        return products.stream()
                .mapToDouble(product -> product.getPrice())
                .sum();
}
}
