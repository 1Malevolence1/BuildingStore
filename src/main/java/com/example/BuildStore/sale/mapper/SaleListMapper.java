package com.example.sale.mapper;


import com.example.sale.dto.SaleResponseDto;
import com.example.sale.model.Sale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SaleMapper.class)
public interface SaleListMapper {

    List<SaleResponseDto> toDto(List<Sale> model);
}
