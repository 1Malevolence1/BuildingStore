package com.example.product.convert;

import com.example.product.dto.ProductTypeCreateRequestDto;
import com.example.product.dto.ProductTypeDto;
import com.example.product.model.ProductType;
import com.example.product.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class ProductTypeManagerImpl implements ProductTypeManager {

    private final ProductTypeMapper productTypeMapper;
    private final ProductTypeListMapper productTypeListMapper;

    @Override
    public ProductType toModel(ProductTypeCreateRequestDto dto) {
        return productTypeMapper.toModel(dto);
    }

    @Override
    public ProductType toModel(ProductUpdateRequestDto dto) {
        return productTypeMapper.toModel(dto);
    }

    @Override
    public List<ProductTypeDto> toDto(List<ProductType> model) {
        return productTypeListMapper.toDto(model);
    }
}
