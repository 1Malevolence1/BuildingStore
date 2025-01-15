package com.example.report.dto;

import java.math.BigDecimal;

public record ReportSalesByProductsResponseDto(
        String productName,
        BigDecimal totalQuantitySold,
        BigDecimal totalRevenue
) {
}
