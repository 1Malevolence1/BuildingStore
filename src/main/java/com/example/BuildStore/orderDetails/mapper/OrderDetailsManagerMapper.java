package com.example.orderDetails.mapper;

import com.example.orderDetails.dto.OrderDetailCreateRequestDto;
import com.example.orderDetails.dto.OrderDetailesResponsetDto;
import com.example.orderDetails.model.OrderDetails;

import java.util.List;

public interface OrderDetailsManagerMapper {

    OrderDetails toModel(OrderDetailCreateRequestDto dto);

    List<OrderDetailesResponsetDto> toDto(List<OrderDetails> model);
}
