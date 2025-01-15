package com.example.report.dto;

import java.math.BigDecimal;

public record ReportSalesByProductTypeResponseDto(
        String typeName,
        BigDecimal totalRevenue
) {
}
