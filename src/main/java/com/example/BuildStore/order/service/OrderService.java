package com.example.order.service;

import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.dto.OrderUpdateRequestDto;

import java.util.List;

public interface OrderService {

    void create(OrderCreateRequestDto dto);
    void update(OrderUpdateRequestDto dto);
    void delete(Long orderId);
    List<OrderResponseDto> getAll();
    void checkOrderById(Long orderId);
}
