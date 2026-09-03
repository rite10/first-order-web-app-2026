package com.capgemini.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.orderservice.dto.ProductResponse;



@FeignClient(name = "PRODUCT-SERVICE")
    public interface  ProductClient {

        @GetMapping("/product/getProduct/{id}")
        ProductResponse getProductByid(@PathVariable Long id);
}

