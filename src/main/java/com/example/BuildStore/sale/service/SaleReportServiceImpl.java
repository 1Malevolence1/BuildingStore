package com.example.sale.service;


import com.example.report.dto.ReportSalesByCustomersResponseDto;
import com.example.report.dto.ReportSalesByProductsResponseDto;
import com.example.sale.repository.SaleRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleReportServiceImpl implements SaleReportService {


    private final SaleRepository saleRepository;


    @Override
    public List<ReportSalesByCustomersResponseDto> findReportSalesByCustomer() {
        List<Tuple> results = saleRepository.reportSalesByCustomers();
        return results.stream()
                .map(tuple -> new ReportSalesByCustomersResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, Long.class),
                        tuple.get(2, BigDecimal.class)))
                .collect(Collectors.toList());

    }

    @Override
    public List<ReportSalesByProductsResponseDto> findReportSalesByProducts() {
        List<Tuple> results = saleRepository.reportSalesByProducts();
        return results.stream()
                .map(tuple -> new ReportSalesByProductsResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, BigDecimal.class),
                        tuple.get(2, BigDecimal.class)))
                .collect(Collectors.toList());
    }
}
