package com.example.productserviceworkshop.services;

import com.example.productserviceworkshop.models.Product;
import com.example.productserviceworkshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String title, String description, double price, String image) {
        //Logic to create product object will come here.
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);

        //Save this product object to DB.
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
