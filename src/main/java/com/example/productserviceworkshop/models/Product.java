package com.example.productserviceworkshop.models;


import com.example.productserviceworkshop.dtos.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment PK.
    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private int inventoryCount;

    public ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getImage());
        return productDto;
    }
}
