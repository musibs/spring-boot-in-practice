package com.manning.sbip.ch02;

import com.manning.sbip.ch02.dao.Dao;
import com.manning.sbip.ch02.dao.ProductDao;
import com.manning.sbip.ch02.model.Product;

public class DaoMain {
    public static void main(String[] args) {
        Dao<Product> productDao = new ProductDao();
        System.out.println("\n ========== List of Products =============");
        productDao.findAll().forEach(System.out::println);

        System.out.println("\n ========= Updates 1st Product Description ========== ");
        Product updatedProduct = Product.builder()
                .productId(Long.valueOf(1))
                .productName("Mobile")
                .productDescription("Best budget mobile with all cool features")
                .productPrice(Double.valueOf(250.50))
                .build();
        productDao.update(0, updatedProduct);
        System.out.println(productDao.findById(0).get());

        System.out.println("\n ========= Deletes 1st Product Details ========== ");
        productDao.delete(updatedProduct);
        productDao.findAll().forEach(System.out::println);
    }
}
