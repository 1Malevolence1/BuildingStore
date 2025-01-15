package com.example.product.convert;


import com.example.product.dto.ProductResponseDto;
import com.example.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface ProductListMapper {

    List<ProductResponseDto> toListDto(List<Product> model);
}
