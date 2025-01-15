package com.example.orderDetails.mapper;


import com.example.orderDetails.dto.OrderDetailesResponsetDto;
import com.example.orderDetails.model.OrderDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderDetailsMapper.class})
public interface OrderDetailsListMapper {

    List<OrderDetailesResponsetDto> toDto(List<OrderDetails> model);
}
