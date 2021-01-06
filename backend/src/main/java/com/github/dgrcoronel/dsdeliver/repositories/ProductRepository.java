package com.github.dgrcoronel.dsdeliver.repositories;

import java.util.List;

import com.github.dgrcoronel.dsdeliver.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByOrderByNameAsc();

}
