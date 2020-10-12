package com.manning.sbip.ch02.controller;

import com.manning.sbip.ch02.entity.Product;
import com.manning.sbip.ch02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{productId}")
    public Optional<Product> findById(@PathVariable("productId") Long productId) {
        return productRepository.findById(productId);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("search/{productCategory}")
    public List<Product> searchProducts(@PathVariable("productCategory") String productCategory) {
        return productRepository.findByProductCategoryOrderByProductPrice(productCategory);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
