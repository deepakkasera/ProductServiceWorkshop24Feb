package com.example.productserviceworkshop.repositories;

import com.example.productserviceworkshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //select * from products where id = 10;

    @Override
    Optional<Product> findById(Long productId);

    @Override
    Product save(Product product);
}

