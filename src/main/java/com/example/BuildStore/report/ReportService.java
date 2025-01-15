package com.example.report;

import com.example.report.dto.*;
import com.example.store.service.ReportEmployeeSalariesByPointOfSaleResponseDto;

import java.util.List;

public interface ReportService {

    List<ReportSalesByCustomersResponseDto> getReportSalesByCustomers();

    List<ReportSalesByProductsResponseDto> getReportSalesByProducts();

    List<ReportSupplyCostsByGoodsResponseDto> getReportSupplyCostsByGoods();

    List<ReportByPointOfStoreResponseDto> getReportByPointOfStore();

    List<ReportPaymentAndOrderStatusResponseDto> getReportPaymentAndOrderStatus();

    List<ReportSalesByProductTypeResponseDto> getReportSalesByProductType();

    List<ReportEmployeeSalariesByPointOfSaleResponseDto> getReportEmployeeSalariesByPointOfSale();
}
