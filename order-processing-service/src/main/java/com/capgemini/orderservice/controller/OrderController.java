package com.capgemini.orderservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderservice.entity.Order;
import com.capgemini.orderservice.service.OrderServiceInf;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderServiceInf orderService;

    public OrderController(OrderServiceInf orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getOrderDetails(){
     List<Order> orders=orderService.getOrder();
     return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PostMapping("/created")
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        orderService.addOrder(order);
        Long id=order.getId();
        return new ResponseEntity<>("Order has created with id "+ id ,HttpStatus.CREATED);
    }
    
}
