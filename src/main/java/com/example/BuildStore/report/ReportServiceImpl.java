package com.example.report;


import com.example.inventory.service.InventoryReportService;
import com.example.payment.service.PaymentReportService;
import com.example.report.dto.*;
import com.example.sale.service.SaleReportService;
import com.example.saleDetails.service.SaleDetailReportService;
import com.example.store.service.ReportEmployeeSalariesByPointOfSaleResponseDto;
import com.example.store.service.StoreReportService;
import com.example.supplier.service.SupplierReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


    private final SaleReportService saleReportService;
    private final SupplierReportService supplierReportService;
    private final InventoryReportService inventoryReportService;
    private final PaymentReportService paymentReportService;
    private final SaleDetailReportService saleDetailReportService;
    private final StoreReportService storeReportService;


    @Override
    public List<ReportSalesByCustomersResponseDto> getReportSalesByCustomers() {
        return saleReportService.findReportSalesByCustomer();
    }

    @Override
    public List<ReportSalesByProductsResponseDto> getReportSalesByProducts() {
        return saleReportService.findReportSalesByProducts();
    }

    @Override
    public List<ReportSupplyCostsByGoodsResponseDto> getReportSupplyCostsByGoods() {
        return supplierReportService.findReportSupplyCostsByGoods();
    }

    @Override
    public List<ReportByPointOfStoreResponseDto> getReportByPointOfStore() {
        return inventoryReportService.findReportByPointOfStore();
    }

    @Override
    public List<ReportPaymentAndOrderStatusResponseDto> getReportPaymentAndOrderStatus() {
        return paymentReportService.findReportPaymentAndOrderStatus();
    }

    @Override
    public List<ReportSalesByProductTypeResponseDto> getReportSalesByProductType() {
        return saleDetailReportService.findReportSalesByProductType();
    }

    @Override
    public List<ReportEmployeeSalariesByPointOfSaleResponseDto> getReportEmployeeSalariesByPointOfSale() {
        return storeReportService.getReportEmployeeSalariesByPointOfSale();
    }
}
