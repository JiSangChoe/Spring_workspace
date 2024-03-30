package com.jisang.testproject.data.dao;
import com.jisang.testproject.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity product);

    ProductEntity getProduct(String productId);

    
}
