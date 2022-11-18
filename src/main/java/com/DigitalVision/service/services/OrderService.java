package com.DigitalVision.service.services;

import com.DigitalVision.service.models.OrderEntity;
import com.DigitalVision.service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity addOrder(OrderEntity orderEntity){

        return orderRepository.save(orderEntity);
    }

    public List<OrderEntity> findAllOrders(){
        return orderRepository.findAll();
    }
}
