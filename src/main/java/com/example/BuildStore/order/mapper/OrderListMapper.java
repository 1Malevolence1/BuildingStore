package com.example.order.mapper;


import com.example.order.dto.OrderResponseDto;
import com.example.order.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface OrderListMapper {

    List<OrderResponseDto> toDto(List<Order> model);
}
