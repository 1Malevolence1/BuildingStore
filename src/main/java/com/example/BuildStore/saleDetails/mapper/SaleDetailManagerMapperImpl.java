package com.example.saleDetails.mapper;

import com.example.sale.dto.SaleResponseDto;
import com.example.saleDetails.dto.SaleDetailCreateRequestDto;
import com.example.saleDetails.dto.SaleDetailUpdateRequestDto;
import com.example.saleDetails.model.SaleDetail;
import com.example.saleDetails.dto.SaleDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class SaleDetailManagerMapperImpl implements SaleDetailManagerMapper {

    private final SaleDetailMapper saleDetailMapper;
    private final SaleDetailListMapper saleDetailListMapper;


    @Override
    public SaleDetail toModel(SaleDetailCreateRequestDto dto) {
        return saleDetailMapper.toEntity(dto);
    }

    @Override
    public SaleDetail toModel(SaleDetailUpdateRequestDto dto) {
        return saleDetailMapper.toEntity(dto);
    }

    @Override
    public SaleDetailResponseDto toDto(SaleDetail model) {
        return saleDetailMapper.toSaleDetailResponseDto(model);
    }

    @Override
    public List<SaleDetailResponseDto> toListDto(List<SaleDetail> model) {
        return saleDetailListMapper.toDto(model);
    }
}
