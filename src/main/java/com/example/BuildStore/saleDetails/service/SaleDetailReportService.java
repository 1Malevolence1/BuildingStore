package com.example.saleDetails.service;

import com.example.report.dto.ReportSalesByProductTypeResponseDto;

import java.util.List;

public interface SaleDetailReportService {

    List<ReportSalesByProductTypeResponseDto> findReportSalesByProductType();
}
