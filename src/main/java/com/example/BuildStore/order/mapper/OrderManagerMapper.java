package com.example.order.mapper;

import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.model.Order;
import com.example.order.dto.OrderUpdateRequestDto;

import java.util.List;

public interface OrderManagerMapper {

    Order toModel(OrderCreateRequestDto dto);
    Order toModel(OrderUpdateRequestDto dto);

    List<OrderResponseDto> toDto(List<Order> model);
}
