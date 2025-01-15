package com.example.report.dto;

import java.math.BigDecimal;

public record ReportSalesByCustomersResponseDto(
        String customer,
        Long numberOfSales,
        BigDecimal totalSpent
) {
}
