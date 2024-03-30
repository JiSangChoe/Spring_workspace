package com.jisang.testproject.data.entity;

import com.jisang.testproject.data.dto.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product")
public class ProductEntity extends BaseEntity {
    
    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

    /* 
    @Column
    String sellerId;

    @Column
    String sellerPhoneNumber;
    */

    public ProductDto toDto(){
        return ProductDto.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
    }
}
