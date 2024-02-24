package com.example.productserviceworkshop.controllers;

import com.example.productserviceworkshop.dtos.ProductDto;
import com.example.productserviceworkshop.models.Product;
import com.example.productserviceworkshop.services.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // This controller is a rest controller, means it is hosting REST API's
@RequestMapping("/products") // All the requests coming to /products endpoint should be routed to this controller.
@Controller
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/")
//    public String helloApi() {
//        return "Hello Everyone, Welcome to API workshop";
//    }

    @GetMapping("/{productId}") // localhost:5151/products/10
    public Product getProductById(@PathVariable Long productId) {
        return new Product();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto.getTitle(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getImage());
    }
}
