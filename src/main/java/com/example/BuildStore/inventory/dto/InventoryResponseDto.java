package com.example.inventory.dto;

import com.example.store.store.StoreResponseDto;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.inventory.model.Inventory}
 */
public record InventoryResponseDto(Long id, Long quantity, LocalDate date, ResponseProductDto product, StoreResponseDto store) {
}