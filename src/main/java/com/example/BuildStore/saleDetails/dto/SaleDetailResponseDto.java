package com.example.saleDetails.dto;

import com.example.product.dto.ProductResponseDto;
import com.example.sale.dto.SaleResponseDto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.saleDetails.model.SaleDetail}
 */
public record SaleDetailResponseDto(Long id, Long quantity, BigDecimal price, SaleResponseDto sale, ProductResponseDto product) {
}