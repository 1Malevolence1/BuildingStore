package com.example.saleDetails.service;

import com.example.report.dto.ReportSalesByProductTypeResponseDto;
import com.example.saleDetails.repository.SaleDetailRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SaleDetailReportServiceImpl implements SaleDetailReportService {

    private final SaleDetailRepository saleDetailRepository;

    @Override
    public List<ReportSalesByProductTypeResponseDto> findReportSalesByProductType() {
        List<Tuple> results = saleDetailRepository.reportReportSalesByProductType();
        return results.stream()
                .map(tuple -> new ReportSalesByProductTypeResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, BigDecimal.class)))
                .collect(Collectors.toList());
    }
}
