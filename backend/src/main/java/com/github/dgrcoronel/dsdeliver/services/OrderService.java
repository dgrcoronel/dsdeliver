package com.github.dgrcoronel.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.github.dgrcoronel.dsdeliver.Dto.OrderDto;
import com.github.dgrcoronel.dsdeliver.entities.Order;
import com.github.dgrcoronel.dsdeliver.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
    }
    
}
