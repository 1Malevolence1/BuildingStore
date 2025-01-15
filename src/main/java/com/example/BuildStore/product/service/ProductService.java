package com.example.product.service;

import com.example.product.dto.ProductCreateRequestDto;
import com.example.product.dto.ProductResponseDto;
import com.example.product.dto.ProductUpdateRequestDto;
import com.example.product.model.Product;

import java.util.List;

public interface ProductService {

    void create(ProductCreateRequestDto dto);
    ProductResponseDto findProduct(Long productId);
    Product getEntityProduct(Long productId);
    List<ProductResponseDto> findAllProduct();
    void deleteProductBuId(Long prodcutId);
    void updateProduct(ProductUpdateRequestDto productId);
}
