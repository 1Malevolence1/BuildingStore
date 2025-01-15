package com.example.order.mapper;

import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.model.Order;
import com.example.order.dto.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class OrderManagerMapperImpl implements OrderManagerMapper {

    private final OrderMapper orderMapper;
    private final OrderListMapper orderListMapper;

    @Override
    public Order toModel(OrderCreateRequestDto dto) {
        return orderMapper.toEntity(dto);
    }

    @Override
    public Order toModel(OrderUpdateRequestDto dto) {
        return orderMapper.toEntity(dto);
    }

    @Override
    public List<OrderResponseDto> toDto(List<Order> model) {
        return orderListMapper.toDto(model);
    }
}
