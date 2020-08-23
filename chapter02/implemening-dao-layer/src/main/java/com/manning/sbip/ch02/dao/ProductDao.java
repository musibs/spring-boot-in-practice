package com.manning.sbip.ch02.dao;

import com.manning.sbip.ch02.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Product> {

    private List<Product> products = new ArrayList<>();

    public ProductDao() {
        products.add(Product.builder()
                .productId(Long.valueOf(1))
                .productName("Mobile")
                .productDescription("Next generation mobile with all cool features")
                .productPrice(Double.valueOf(250.50))
                .build());
        products.add(Product.builder()
                .productId(Long.valueOf(2))
                .productName("Laptop")
                .productDescription("Next generation laptop with all cool features")
                .productPrice(Double.valueOf(1120))
                .build());
    }
    @Override
    public Optional<Product> findById(long Id) {
        return Optional.ofNullable(products.get((int) Id));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(long Id, Product updatedProduct) {
        Optional<Product> existingProduct = findById(Id);
        existingProduct.ifPresent(product -> {
            product.setProductName(updatedProduct.getProductName());
            product.setProductDescription(updatedProduct.getProductDescription());
            product.setProductPrice(updatedProduct.getProductPrice());
        });
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}