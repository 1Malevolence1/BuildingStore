package com.example.saleDetails.mapper;


import com.example.saleDetails.model.SaleDetail;
import com.example.saleDetails.dto.SaleDetailResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SaleDetailMapper.class)
public interface SaleDetailListMapper {

    List<SaleDetailResponseDto> toDto(List<SaleDetail> model);
}
