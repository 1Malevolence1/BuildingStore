package com.example.supplier.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link com.example.supplier.model.Supplier}
 */
public record SupplierCreateRequestDto(LocalDate supplyDate, Long quantity, Long orderId,
                                       Long productId) {
}