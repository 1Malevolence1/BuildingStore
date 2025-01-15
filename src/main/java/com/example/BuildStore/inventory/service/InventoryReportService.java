package com.example.inventory.service;

import com.example.report.dto.ReportByPointOfStoreResponseDto;

import java.util.List;

public interface InventoryReportService {

    List<ReportByPointOfStoreResponseDto> findReportByPointOfStore();
}
