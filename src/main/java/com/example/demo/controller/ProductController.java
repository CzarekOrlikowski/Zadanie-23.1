package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class ProductController {

//    private ProductRepository productRepository;
//
//    @Autowired
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/lista")
    public String getProductsList(Model model) {
        Set<Product> products = productService.findAll();
        Double totalPrice = productService.showTotalPrice(products);
        model.addAttribute("products", products);
        model.addAttribute("price", totalPrice);
        return "lista";
    }

    @GetMapping("/tabela")
    public String getProductsTable(Model model) {
        Set<Product> products = productService.findAll();
        Double totalPrice = productService.showTotalPrice(products);
        model.addAttribute("products", products);
        model.addAttribute("price", totalPrice);
        return "tabela";
    }

    @GetMapping("/")
    String getUserForm(Model model) {
        Product attributeValue = new Product();
        model.addAttribute("product", attributeValue);
        return "index";
    }

    @PostMapping("/add")
    String add(Product product) {
        productService.add(product);
        return "redirect:/tabela";
    }

}
