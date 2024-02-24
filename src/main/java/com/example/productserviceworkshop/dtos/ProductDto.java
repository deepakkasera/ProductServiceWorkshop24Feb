package com.example.productserviceworkshop.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    //Product DTO will contain the values that we need in the input to create a Product object.
    private String title;
    private String description;
    private double price;
    private String image;
}
