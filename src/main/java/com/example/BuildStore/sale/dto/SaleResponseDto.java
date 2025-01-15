package com.example.sale.dto;

import com.example.customers.dto.CustomerResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.sale.model.Sale}
 */
public record SaleResponseDto(Long id, LocalDate saleDate, BigDecimal totalAmount, CustomerResponseDto customer) {
}