package com.example.report.dto;

import java.math.BigDecimal;

public record ReportPaymentAndOrderStatusResponseDto(
        String storeName,
        String orderStatus,
        BigDecimal sum
) {
}
