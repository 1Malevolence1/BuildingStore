package com.example.saleDetails.mapper;

import com.example.product.convert.ProductMapper;
import com.example.sale.mapper.SaleMapper;
import com.example.saleDetails.dto.SaleDetailUpdateRequestDto;
import com.example.saleDetails.model.SaleDetail;
import com.example.saleDetails.dto.SaleDetailCreateRequestDto;
import com.example.saleDetails.dto.SaleDetailResponseDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {SaleMapper.class, ProductMapper.class})
public interface SaleDetailMapper {
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "saleId", target = "sale.id")
    SaleDetail toEntity(SaleDetailCreateRequestDto saleDetailCreateRequestDto);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "saleId", target = "sale.id")
    SaleDetail toEntity(SaleDetailUpdateRequestDto saleDetailUpdateRequestDto);

    SaleDetail toEntity(SaleDetailResponseDto saleDetailResponseDto);

    @InheritInverseConfiguration(name = "toEntity")
    SaleDetailResponseDto toSaleDetailResponseDto(SaleDetail saleDetail);
}