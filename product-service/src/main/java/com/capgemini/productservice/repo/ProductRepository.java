package com.capgemini.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
