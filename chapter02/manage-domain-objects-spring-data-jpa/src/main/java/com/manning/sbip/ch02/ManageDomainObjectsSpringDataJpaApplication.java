package com.manning.sbip.ch02;

import com.manning.sbip.ch02.entity.Product;
import com.manning.sbip.ch02.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ManageDomainObjectsSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageDomainObjectsSpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(ProductRepository productRepository) {
        return args -> {
            Product product1 = Product.builder()
                    .productName("iPhone11")
                    .productCategory("Mobile")
                    .productDescription("Next generation mobile with all cool features")
                    .productPrice(Double.valueOf(699))
                    .build();
            Product product2 = Product.builder()
                    .productName("Samsung Galaxy")
                    .productCategory("Mobile")
                    .productDescription("Next generation mobile with all cool features")
                    .productPrice(Double.valueOf(158))
                    .build();
            Product product3 = Product.builder()
                    .productName("Dell Laptop")
                    .productCategory("Laptop")
                    .productDescription("Next generation laptop with all cool features")
                    .productPrice(Double.valueOf(1120))
                    .build();
            Product product4 = Product.builder()
                    .productName("Lenovo Laptop")
                    .productCategory("Laptop")
                    .productDescription("Next generation laptop with intel core i7 processor")
                    .productPrice(Double.valueOf(1300))
                    .build();

            productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));
        };
    }
}
