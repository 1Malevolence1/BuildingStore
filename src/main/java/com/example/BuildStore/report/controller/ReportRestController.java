package com.example.report.controller;


import com.example.report.ReportService;
import com.example.report.dto.*;
import com.example.store.service.ReportEmployeeSalariesByPointOfSaleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/report")
@RequiredArgsConstructor
public class ReportRestController {

    private final ReportService reportService;

    @CrossOrigin("*")
    @GetMapping("/1")
    public ResponseEntity<List<ReportSalesByCustomersResponseDto>> getReportOne() {
        return ResponseEntity.ok(
                reportService.getReportSalesByCustomers()
        );
    }

    @CrossOrigin("*")
    @GetMapping("/2")
    public ResponseEntity<List<ReportSalesByProductsResponseDto>> getReportTwo() {
        return ResponseEntity.ok(
                reportService.getReportSalesByProducts()
        );
    }

    @CrossOrigin("*")
    @GetMapping("/3")
    public ResponseEntity<List<ReportSupplyCostsByGoodsResponseDto>> getReportThree() {
        return ResponseEntity.ok(
                reportService.getReportSupplyCostsByGoods()
        );
    }

    @CrossOrigin("*")
    @GetMapping("/4")
    public ResponseEntity<List<ReportByPointOfStoreResponseDto>> getReportFour() {
        return ResponseEntity.ok(
                reportService.getReportByPointOfStore()
        );
    }

    @CrossOrigin("*")
    @GetMapping("/5")
    public ResponseEntity<List<ReportPaymentAndOrderStatusResponseDto>> getReportFive() {
        return ResponseEntity.ok(
                reportService.getReportPaymentAndOrderStatus()
        );
    }

    @CrossOrigin("*")
    @GetMapping("/6")
    public ResponseEntity<List<ReportSalesByProductTypeResponseDto>> getReportSix() {
        return ResponseEntity.ok(
                reportService.getReportSalesByProductType()
        );
    }

    @CrossOrigin("*")
    @GetMapping("/7")
    public ResponseEntity<List<ReportEmployeeSalariesByPointOfSaleResponseDto>> getReportSeven() {
        return ResponseEntity.ok(
                reportService.getReportEmployeeSalariesByPointOfSale()
        );
    }
}