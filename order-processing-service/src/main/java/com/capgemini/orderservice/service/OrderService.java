package com.capgemini.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.capgemini.orderservice.dto.ProductResponse;
import com.capgemini.orderservice.entity.Order;
import com.capgemini.orderservice.repo.OrderRepository;

@Service
public class OrderService implements OrderServiceInf {

    private OrderRepository repository;
    private ProductClient  productClient;

    public OrderService(OrderRepository repository,ProductClient  productClient) {
        this.repository = repository;
        this.productClient=productClient;
    }

    @Override
    public List<Order> getOrder() {
        List<Order> order= repository.findAll();
        return order;
    }


    @Override
    public void addOrder(Order order) {
        ProductResponse product =
            productClient.getProductByid(order.getProductId());
        
        if (product.getQuantity() < order.getQuantity()) {
        throw new RuntimeException("Insufficient stock");
        }
        
        order.setPrice(product.getPrice() * order.getQuantity());
        order.setStatus("PENDING");
        System.out.println(product);

        repository.save(order);
    }
    
}
