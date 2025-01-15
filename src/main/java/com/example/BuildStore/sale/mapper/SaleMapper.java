package com.example.sale.mapper;

import com.example.customers.mapper.CustomerMapper;
import com.example.sale.dto.SaleCreateRequestDto;
import com.example.sale.dto.SaleResponseDto;
import com.example.sale.dto.SaleUpdateRequestDto;
import com.example.sale.model.Sale;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CustomerMapper.class})
public interface SaleMapper {
    @Mapping(source = "customerId", target = "customer.id")
    Sale toEntity(SaleCreateRequestDto saleCreateRequestDto);

    @Mapping(source = "customer.id", target = "customerId")
    SaleCreateRequestDto toSaleCreateRequestDto(Sale sale);

    @Mapping(source = "customerId", target = "customer.id")
    Sale toEntity(SaleUpdateRequestDto saleUpdateRequestDto);

    @InheritInverseConfiguration(name = "toEntity")
    SaleUpdateRequestDto toSaleUpdateRequestDto(Sale sale);

    Sale toEntity(SaleResponseDto saleResponseDto);

    @InheritInverseConfiguration(name = "toEntity")
    SaleResponseDto toSaleResponseDto(Sale sale);
}