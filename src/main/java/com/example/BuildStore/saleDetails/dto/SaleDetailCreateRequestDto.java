package com.example.saleDetails.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.saleDetails.model.SaleDetail}
 */
public record SaleDetailCreateRequestDto(Long quantity, BigDecimal price, Long saleId, Long productId) {
}