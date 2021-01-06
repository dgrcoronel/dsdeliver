package com.github.dgrcoronel.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.github.dgrcoronel.dsdeliver.Dto.ProductDto;
import com.github.dgrcoronel.dsdeliver.entities.Product;
import com.github.dgrcoronel.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        List<Product> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
    }
    
}
