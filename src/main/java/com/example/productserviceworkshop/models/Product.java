package com.example.productserviceworkshop.models;


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
}
