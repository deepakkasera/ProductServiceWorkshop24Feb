package com.example.productserviceworkshop.services;

import com.example.productserviceworkshop.exceptions.InvalidProductException;
import com.example.productserviceworkshop.models.Product;
import com.example.productserviceworkshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long productId) throws InvalidProductException {
        //Go to DB and fetch the product with given Id.
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            //We are getting invalid productId in the input.
            //Throw an exception -> Exceptions.
            throw new InvalidProductException("Invalid productId passed to Service");
        }

        return optionalProduct.get();
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
