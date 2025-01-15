package com.example.report.dto;

import java.math.BigDecimal;
import java.util.Date;

public record ReportSupplyCostsByGoodsResponseDto(
        String productName,
        BigDecimal totalSupplied,
        Date lastSupplyDate
) {
}
