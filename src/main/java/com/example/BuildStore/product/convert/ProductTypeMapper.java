package com.example.product.convert;


import com.example.product.dto.ProductTypeCreateRequestDto;
import com.example.product.dto.ProductTypeDto;
import com.example.product.model.ProductType;
import com.example.product.dto.ProductUpdateRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {

    ProductType toModel(ProductTypeCreateRequestDto dto);
    ProductType toModel(ProductUpdateRequestDto dto);

    ProductTypeDto toDto(ProductType model);
}
