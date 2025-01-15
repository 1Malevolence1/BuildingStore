package com.example.order.dto;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.order.model.Order}
 */
public record OrderCreateRequestDto(LocalDate orderDate, String status, Long storeId) {
}