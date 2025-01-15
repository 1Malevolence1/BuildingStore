package com.example.payment.service;

import com.example.report.dto.ReportPaymentAndOrderStatusResponseDto;

import java.util.List;

public interface PaymentReportService {

    List<ReportPaymentAndOrderStatusResponseDto> findReportPaymentAndOrderStatus();
}
