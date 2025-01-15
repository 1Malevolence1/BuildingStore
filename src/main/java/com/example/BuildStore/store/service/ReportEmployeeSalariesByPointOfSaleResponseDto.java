package com.example.store.service;

import java.math.BigDecimal;

public record ReportEmployeeSalariesByPointOfSaleResponseDto(
        String storeName,
        Long employeeCount,
        BigDecimal totalSalaries
) {
}
