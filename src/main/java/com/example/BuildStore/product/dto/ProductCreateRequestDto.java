package com.example.product.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.product.model.Product}
 */
public record ProductCreateRequestDto(String productName, BigDecimal price, Long stock,  Long productTypeId) {
}