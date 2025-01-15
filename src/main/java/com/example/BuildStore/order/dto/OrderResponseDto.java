package com.example.order.dto;

import com.example.store.store.StoreResponseDto;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.order.model.Order}
 */
public record OrderResponseDto(Long id, LocalDate orderDate, String status, StoreResponseDto store) {
}