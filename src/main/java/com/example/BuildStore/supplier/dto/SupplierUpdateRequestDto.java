package com.example.supplier.dto;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.supplier.model.Supplier}
 */
public record SupplierUpdateRequestDto(Long id, LocalDate supplyDate, Long quantity, Long orderId,
                                       Long productId) {
}