package com.github.dgrcoronel.dsdeliver.resources;

import java.util.List;

import com.github.dgrcoronel.dsdeliver.Dto.OrderDto;
import com.github.dgrcoronel.dsdeliver.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        List<OrderDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
}
