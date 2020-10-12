package com.manning.sbip.ch02.repository;

import com.manning.sbip.ch02.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByProductCategoryOrderByProductPrice(String productCategory);
}
