package com.example.product.convert;

import com.example.product.dto.ProductCreateRequestDto;
import com.example.product.dto.ProductResponseDto;
import com.example.product.model.Product;
import com.example.product.dto.ProductUpdateRequestDto;

import java.util.List;

public interface ProductManagerMapper {

    Product toModel(ProductCreateRequestDto dto);
    Product toModel(ProductUpdateRequestDto dto);
    ProductResponseDto toDto(Product model);
    List<ProductResponseDto> toListDto(List<Product> model);

}
