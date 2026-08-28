package com.capgemini.orderservice.service;

import java.util.List;

import com.capgemini.orderservice.entity.Order;

public interface OrderServiceInf {
public  List<Order> getOrder();
public  void addOrder(Order order);
}
