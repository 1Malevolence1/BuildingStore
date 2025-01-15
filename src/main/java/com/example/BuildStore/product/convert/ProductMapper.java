package com.example.product.convert;

import com.example.product.dto.ProductCreateRequestDto;
import com.example.product.dto.ProductResponseDto;
import com.example.product.dto.ProductTypeCreateRequestDto;
import com.example.product.model.Product;
import com.example.product.model.ProductType;
import com.example.product.dto.ProductUpdateRequestDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(target = "productType", ignore = true)
    Product toEntity(ProductCreateRequestDto responseProductDto);

    @Mapping(target = "productType", ignore = true)
    Product toEntity(ProductUpdateRequestDto responseProductDto);

    ProductResponseDto toResponseProductDto(Product product);

    ProductType toEntity(ProductTypeCreateRequestDto productTypeCreateRequestDto);

    @InheritInverseConfiguration(name = "toEntity")
    ProductTypeCreateRequestDto toProductTypeCreateRequestDto(ProductType productType);

    Product toEntity(ProductResponseDto productResponseDto);
}