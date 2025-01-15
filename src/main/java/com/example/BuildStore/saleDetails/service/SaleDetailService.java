package com.example.saleDetails.service;

import com.example.saleDetails.dto.SaleDetailCreateRequestDto;
import com.example.saleDetails.dto.SaleDetailResponseDto;
import com.example.saleDetails.dto.SaleDetailUpdateRequestDto;

import java.util.List;

public interface SaleDetailService {

    void create(SaleDetailCreateRequestDto dto);
    void update(SaleDetailUpdateRequestDto dto);
    SaleDetailResponseDto get(Long id);
    List<SaleDetailResponseDto> getAll();
    void delete(Long id);
}
