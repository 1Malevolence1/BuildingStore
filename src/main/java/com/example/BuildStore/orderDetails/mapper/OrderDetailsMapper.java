package com.example.orderDetails.mapper;

import com.example.order.mapper.OrderMapper;
import com.example.orderDetails.dto.OrderDetailCreateRequestDto;
import com.example.orderDetails.dto.OrderDetailesResponsetDto;
import com.example.orderDetails.model.OrderDetails;
import com.example.product.convert.ProductMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class, ProductMapper.class})
public interface OrderDetailsMapper {
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderId", target = "order.id")
    OrderDetails toEntity(OrderDetailCreateRequestDto orderDetailCreateRequestDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderDetailCreateRequestDto toOrderDetailCreateRequestDto(OrderDetails orderDetails);

    OrderDetails toEntity(OrderDetailesResponsetDto orderDetailesResponsetDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderDetailesResponsetDto toOrderDetailesponsetDto(OrderDetails orderDetails);
}