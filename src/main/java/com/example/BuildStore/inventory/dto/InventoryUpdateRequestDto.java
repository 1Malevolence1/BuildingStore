package com.example.inventory.dto;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.inventory.model.Inventory}
 */
public record InventoryUpdateRequestDto(Long id, Long quantity, LocalDate date, Long productId, Long storeId) {
}