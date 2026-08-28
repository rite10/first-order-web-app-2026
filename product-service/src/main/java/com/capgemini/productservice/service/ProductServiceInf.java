package com.capgemini.productservice.service;

import java.util.List;

import com.capgemini.productservice.entity.Product;

public interface ProductServiceInf {
public  List<Product> getOrder();
public  void addOrder(Product order);
}
