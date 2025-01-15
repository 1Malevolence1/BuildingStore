package com.example.supplier.service;

import com.example.report.dto.ReportSupplyCostsByGoodsResponseDto;

import java.util.List;

public interface SupplierReportService {

        List<ReportSupplyCostsByGoodsResponseDto> findReportSupplyCostsByGoods();
}
