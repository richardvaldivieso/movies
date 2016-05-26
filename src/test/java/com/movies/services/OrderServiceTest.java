package com.movies.services;

import com.movies.model.OrderEntity;
import com.movies.repository.OrderRepository;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    @Test
    public void addOrder(){
        OrderRepository  orderRepository = mock(OrderRepository.class);
        OrderEntity orderEntity = new OrderEntity("Approved", 6.5);
        OrderService orderService = new OrderService(orderRepository);
        orderService.addOrder(orderEntity);

        verify(orderRepository).save(orderEntity);

    }

}