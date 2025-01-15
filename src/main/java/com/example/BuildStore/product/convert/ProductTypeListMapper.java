package com.example.product.convert;


import com.example.product.dto.ProductTypeDto;
import com.example.product.model.ProductType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductTypeMapper.class)
public interface ProductTypeListMapper {

    List<ProductTypeDto> toDto(List<ProductType> model);
}
