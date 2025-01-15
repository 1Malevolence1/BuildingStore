package com.example.supplier.service;

import com.example.report.dto.ReportSupplyCostsByGoodsResponseDto;
import com.example.supplier.repository.SupplierRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierReportServiceImpl implements SupplierReportService {

    private final SupplierRepository supplierRepository;

    @Override
    public List<ReportSupplyCostsByGoodsResponseDto> findReportSupplyCostsByGoods() {
        List<Tuple> results = supplierRepository.reportReportSupplyCostsByGoodsResponseDto();
        return results.stream()
                .map(tuple -> new ReportSupplyCostsByGoodsResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, BigDecimal.class),
                        tuple.get(2, Date.class)))
                .collect(Collectors.toList());
    }
}
