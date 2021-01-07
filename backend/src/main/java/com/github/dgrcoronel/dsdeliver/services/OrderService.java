package com.github.dgrcoronel.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.github.dgrcoronel.dsdeliver.Dto.OrderDto;
import com.github.dgrcoronel.dsdeliver.Dto.ProductDto;
import com.github.dgrcoronel.dsdeliver.entities.Order;
import com.github.dgrcoronel.dsdeliver.entities.OrderStatus;
import com.github.dgrcoronel.dsdeliver.entities.Product;
import com.github.dgrcoronel.dsdeliver.repositories.OrderRepository;
import com.github.dgrcoronel.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto insert(OrderDto dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLatitude(), 
            Instant.now(), OrderStatus.PENDING);
        for (ProductDto p : dto.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDto(order);
    }

    @Transactional
    public OrderDto setDelivered(Long id) {
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DEVLIVERD);
        order = repository.save(order);
        return new OrderDto(order);
    }
    
}
