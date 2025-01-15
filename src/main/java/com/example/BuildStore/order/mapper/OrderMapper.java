package com.example.order.mapper;

import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.model.Order;
import com.example.order.dto.OrderUpdateRequestDto;
import com.example.store.mapper.StoreMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {StoreMapper.class})
public interface OrderMapper {
    @Mapping(source = "storeId", target = "store.id")
    Order toEntity(OrderCreateRequestDto orderCreateRequestDto);

    @Mapping(source = "store.id", target = "storeId")
    OrderCreateRequestDto toOrderCreateRequestDto(Order order);

    Order toEntity(OrderResponseDto orderResponseDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderResponseDto toOrderResponseDto(Order order);

    Order toEntity(OrderUpdateRequestDto orderUpdateRequestDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderUpdateRequestDto toOrderUpdateRequestDto(Order order);
}