package com.example.sale.mapper;

import com.example.sale.dto.SaleCreateRequestDto;
import com.example.sale.dto.SaleResponseDto;
import com.example.sale.dto.SaleUpdateRequestDto;
import com.example.sale.model.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class SaleManagerMapperImpl implements SaleManagerMapper {

    private final SaleMapper saleMapper;
    private final SaleListMapper saleListMapper;

    @Override
    public Sale toModel(SaleCreateRequestDto dto) {
        return saleMapper.toEntity(dto);
    }

    @Override
    public Sale toModel(SaleUpdateRequestDto dto) {
        return saleMapper.toEntity(dto);
    }

    @Override
    public SaleResponseDto toDto(Sale model) {
        return saleMapper.toSaleResponseDto(model);
    }

    @Override
    public List<SaleResponseDto> toListDto(List<Sale> model) {
        return saleListMapper.toDto(model);
    }
}
