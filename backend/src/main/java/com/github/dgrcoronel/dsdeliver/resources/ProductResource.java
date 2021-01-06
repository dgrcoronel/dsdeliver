package com.github.dgrcoronel.dsdeliver.resources;

import java.util.List;

import com.github.dgrcoronel.dsdeliver.Dto.ProductDto;
import com.github.dgrcoronel.dsdeliver.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
}
