package com.example.sale.service;

import com.example.report.dto.ReportSalesByCustomersResponseDto;
import com.example.report.dto.ReportSalesByProductsResponseDto;

import java.util.List;

public interface SaleReportService {

    List<ReportSalesByCustomersResponseDto> findReportSalesByCustomer();

    List<ReportSalesByProductsResponseDto> findReportSalesByProducts();
}
