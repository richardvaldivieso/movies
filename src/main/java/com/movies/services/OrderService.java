package com.movies.services;

import com.movies.model.OrderEntity;
import com.movies.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void addOrder(OrderEntity orderEntity){
        orderRepository.save(orderEntity);
    }
}
