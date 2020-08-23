package com.manning.sbip.ch02.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;
    private String productCategory;
    private String productDescription;
    private double productPrice;
}

