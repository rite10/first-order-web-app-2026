package com.capgemini.productservice.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.capgemini.productservice.entity.Product;
import com.capgemini.productservice.repo.ProductRepository;

@Service
public class ProductService implements ProductServiceInf {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> getOrder() {
        List<Product> order= repository.findAll();
        return order;
    }


    @Override
    public void addOrder(Product order) {
        repository.save(order);
    }
    
}
