package com.example.report.dto;

public record ReportByPointOfStoreResponseDto(
        String storeName,
        String productName,
        Long stockQuantity
) {
}
