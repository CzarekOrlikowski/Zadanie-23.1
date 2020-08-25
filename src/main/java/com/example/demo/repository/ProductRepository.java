package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>();
        products.add(new Product("rower", 3500));
        products.add(new Product("kask", 240));
        products.add(new Product("opona", 90));
    }

//    public Optional<Product> findByName(String name) {
//
//        return products.stream()
//                .filter(product -> product.getName().equals(name))
//                .findFirst();
//    }

    public Set<Product> findAll() {

        return new HashSet<>(products);
    }

    public void add(Product product) {

        products.add(product);
    }
}
