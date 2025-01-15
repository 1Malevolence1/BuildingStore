package com.example.inventory.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.product.model.Product}
 */
public record ResponseProductDto(Long id, String productName, BigDecimal price, Long stock) {
}