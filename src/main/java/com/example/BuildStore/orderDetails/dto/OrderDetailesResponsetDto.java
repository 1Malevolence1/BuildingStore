package com.example.orderDetails.dto;

import com.example.order.dto.OrderResponseDto;
import com.example.product.dto.ProductResponseDto;

/**
 * DTO for {@link com.example.orderDetails.model.OrderDetails}
 */
public record OrderDetailesResponsetDto(Long id, OrderResponseDto order, ProductResponseDto product, Long quantity) {
}