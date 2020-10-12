package com.manning.sbip.ch02.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
}
