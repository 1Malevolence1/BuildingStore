package com.example.product.convert;


import com.example.product.dto.ProductTypeCreateRequestDto;
import com.example.product.dto.ProductTypeDto;
import com.example.product.model.ProductType;
import com.example.product.dto.ProductUpdateRequestDto;

import java.util.List;

public interface ProductTypeManager {

    ProductType toModel(ProductTypeCreateRequestDto dto);
    ProductType toModel(ProductUpdateRequestDto dto);
    List<ProductTypeDto> toDto(List<ProductType> model);
}
