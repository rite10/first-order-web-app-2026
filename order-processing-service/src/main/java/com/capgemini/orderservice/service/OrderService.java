package com.capgemini.orderservice.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.capgemini.orderservice.entity.Order;
import com.capgemini.orderservice.repo.OrderRepository;

@Service
public class OrderService implements OrderServiceInf {

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Order> getOrder() {
        List<Order> order= repository.findAll();
        return order;
    }


    @Override
    public void addOrder(Order order) {
        repository.save(order);
    }
    
}
