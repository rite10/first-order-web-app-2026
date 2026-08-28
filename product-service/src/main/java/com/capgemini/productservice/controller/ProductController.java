package com.capgemini.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.productservice.entity.Product;
import com.capgemini.productservice.service.ProductServiceInf;

@RestController
@RequestMapping("/order")
public class ProductController {

    private ProductServiceInf orderService;

    public ProductController(ProductServiceInf orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getOrderDetails(){
     List<Product> orders=orderService.getOrder();
     return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PostMapping("/created")
    public ResponseEntity<String> createOrder(@RequestBody Product order){
        orderService.addOrder(order);
        Long id=order.getId();
        return new ResponseEntity<>("Order has created with id "+ id ,HttpStatus.CREATED);
    }
    
}
