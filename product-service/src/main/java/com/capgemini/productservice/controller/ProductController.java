package com.capgemini.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.productservice.entity.Product;
import com.capgemini.productservice.service.ProductServiceInf;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServiceInf productService;

    public ProductController(ProductServiceInf productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getOrderDetails(){
     List<Product> products=productService.getAllProduct();
     return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<String> createOrder(@RequestBody Product order){
        productService.addProduct(order);
        Long id=order.getId();
        return new ResponseEntity<>("Product has stored with id "+ id ,HttpStatus.CREATED);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getOrderById(@PathVariable Long id){
             Product product= productService.fetchProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);

    }
    
}
