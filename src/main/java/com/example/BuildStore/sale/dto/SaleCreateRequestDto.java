package com.example.sale.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.sale.model.Sale}
 */
public record SaleCreateRequestDto(LocalDate saleDate, BigDecimal totalAmount, Long customerId) {
}