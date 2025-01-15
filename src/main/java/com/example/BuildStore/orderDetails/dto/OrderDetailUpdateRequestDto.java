package com.example.orderDetails.dto;

/**
 * DTO for {@link com.example.orderDetails.model.OrderDetails}
 */
public record OrderDetailUpdateRequestDto(Long id, Long orderId, Long productId, Long quantity) {
}