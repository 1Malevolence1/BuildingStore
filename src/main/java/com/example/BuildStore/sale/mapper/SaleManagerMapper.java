package com.example.sale.mapper;

import com.example.sale.dto.SaleCreateRequestDto;
import com.example.sale.dto.SaleResponseDto;
import com.example.sale.dto.SaleUpdateRequestDto;
import com.example.sale.model.Sale;

import java.util.List;

public interface SaleManagerMapper {

    Sale toModel(SaleCreateRequestDto dto);
    Sale toModel(SaleUpdateRequestDto dto);

    SaleResponseDto toDto(Sale model);
    List<SaleResponseDto> toListDto(List<Sale> model);
}
