package com.capgemini.productservice.service;

import java.util.List;

import com.capgemini.productservice.entity.Product;

public interface ProductServiceInf {
public  List<Product> getAllProduct();
public  void addProduct(Product order);
public  Product fetchProductById(Long id);
}
