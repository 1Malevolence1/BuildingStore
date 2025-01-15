package com.example.saleDetails.mapper;

import com.example.saleDetails.dto.SaleDetailCreateRequestDto;
import com.example.saleDetails.dto.SaleDetailUpdateRequestDto;
import com.example.saleDetails.model.SaleDetail;
import com.example.saleDetails.dto.SaleDetailResponseDto;

import java.util.List;

public interface SaleDetailManagerMapper {

    SaleDetail toModel(SaleDetailCreateRequestDto dto);
    SaleDetail toModel(SaleDetailUpdateRequestDto dto);

    SaleDetailResponseDto toDto(SaleDetail model);
    List<SaleDetailResponseDto> toListDto(List<SaleDetail> model);
}
