package com.example.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.payment.model.Payment}
 */
public record PaymentCreateRequestDto(LocalDate paymentDate, BigDecimal amount, Long saleId) {
}