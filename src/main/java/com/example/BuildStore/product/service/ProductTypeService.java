package com.example.product.service;

import com.example.product.dto.*;

import java.util.List;


public interface ProductTypeService {

    void createProductType(ProductTypeCreateRequestDto dto);
    void updateProductType(ProductTypeUpdateRequestDto dto);
    void deleteProductType(Long prodcutTypeId);
    List<ProductTypeDto> getAll();
}
