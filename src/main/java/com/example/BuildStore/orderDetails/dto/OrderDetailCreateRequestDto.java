package com.example.orderDetails.dto;

/**
 * DTO for {@link com.example.orderDetails.model.OrderDetails}
 */
public record OrderDetailCreateRequestDto(Long orderId, Long productId, Long quantity) {
}