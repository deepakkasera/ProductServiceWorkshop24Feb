package com.example.productserviceworkshop.controllers;

import com.example.productserviceworkshop.dtos.ProductDto;
import com.example.productserviceworkshop.dtos.UserDto;
import com.example.productserviceworkshop.exceptions.InvalidProductException;
import com.example.productserviceworkshop.models.Product;
import com.example.productserviceworkshop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController // This controller is a rest controller, means it is hosting REST API's
@RequestMapping("/products") // All the requests coming to /products endpoint should be routed to this controller.
@Controller
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    ProductController(ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

//    @GetMapping("/")
//    public String helloApi() {
//        return "Hello Everyone, Welcome to API workshop";
//    }

    @GetMapping("/{productId}") // localhost:5151/products/10
    public ProductDto getProductById(@PathVariable Long productId) throws InvalidProductException {
        Product product = productService.getProductById(productId);

        //Call the UserService, and check if user is logged in.
        ResponseEntity<UserDto> responseEntity =
                restTemplate.getForEntity("http://userserviceworkshop/users/13", UserDto.class);

        System.out.println(responseEntity.getBody().getEmail());

        //Convert Product object to ProductDto
        return product.from(product);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto.getTitle(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getImage());
    }


}
