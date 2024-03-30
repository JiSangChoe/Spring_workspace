package com.jisang.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jisang.testproject.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String>{
    
}
