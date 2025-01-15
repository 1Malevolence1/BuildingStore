package com.example.product.convert;

import com.example.product.dto.ProductCreateRequestDto;
import com.example.product.dto.ProductResponseDto;
import com.example.product.model.Product;
import com.example.product.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ProductManagerMapperImpl implements ProductManagerMapper {

    private final ProductMapper productMapper;
    private final ProductListMapper productListMapper;

    @Override
    public Product toModel(ProductCreateRequestDto dto) {
        return productMapper.toEntity(dto);
    }

    @Override
    public Product toModel(ProductUpdateRequestDto dto) {
        return productMapper.toEntity(dto);
    }

    @Override
    public
    ProductResponseDto toDto(Product model) {
        return productMapper.toResponseProductDto(model);
    }

    @Override
    public List<ProductResponseDto> toListDto(List<Product> model) {
        return productListMapper.toListDto(model);
    }
}
