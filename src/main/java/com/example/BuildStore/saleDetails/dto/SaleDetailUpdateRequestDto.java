package com.example.saleDetails.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.saleDetails.model.SaleDetail}
 */
public record SaleDetailUpdateRequestDto(Long id, Long quantity, BigDecimal price, Long saleId, Long productId) {
}