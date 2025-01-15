package com.example.orderDetails.service;

import com.example.orderDetails.dto.OrderDetailCreateRequestDto;
import com.example.orderDetails.dto.OrderDetailUpdateRequestDto;
import com.example.orderDetails.dto.OrderDetailesResponsetDto;

import java.util.List;

public interface OrderDetailService {

    void add(OrderDetailCreateRequestDto dto);
    void update(OrderDetailUpdateRequestDto dto);
    void delete(Long orderDetailsId);
    List<OrderDetailesResponsetDto> getAll();
}
