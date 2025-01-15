package com.example.product.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.product.model.Product}
 */
public record ProductUpdateRequestDto(Long id, String productName, BigDecimal price, Long stock,
                                      Long productTypeId) {
}