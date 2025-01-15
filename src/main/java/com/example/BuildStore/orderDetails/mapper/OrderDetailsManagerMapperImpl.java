package com.example.orderDetails.mapper;

import com.example.orderDetails.dto.OrderDetailCreateRequestDto;
import com.example.orderDetails.dto.OrderDetailesResponsetDto;
import com.example.orderDetails.model.OrderDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class OrderDetailsManagerMapperImpl implements OrderDetailsManagerMapper {

    private final OrderDetailsMapper orderDetailsMapper;
    private final OrderDetailsListMapper orderDetailsListMapper;


    @Override
    public OrderDetails toModel(OrderDetailCreateRequestDto dto) {
        return orderDetailsMapper.toEntity(dto);
    }


    @Override
    public List<OrderDetailesResponsetDto> toDto(List<OrderDetails> model) {
        return orderDetailsListMapper.toDto(model);
    }
}
