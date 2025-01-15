package com.example.payment.service;

import com.example.payment.repostiory.PaymentRepository;
import com.example.report.dto.ReportPaymentAndOrderStatusResponseDto;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PaymentReportServiceImpl implements PaymentReportService {


    private final PaymentRepository paymentRepository;

    @Override
    public List<ReportPaymentAndOrderStatusResponseDto> findReportPaymentAndOrderStatus() {
        List<Tuple> results = paymentRepository.reportPaymentAndOrderStatus();
        return results.stream()
                .map(tuple -> new ReportPaymentAndOrderStatusResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, String.class),
                        tuple.get(2, BigDecimal.class)))
                .collect(Collectors.toList());
    }
}
