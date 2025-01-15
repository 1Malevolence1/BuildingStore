package com.example.store.service;

import com.example.store.repository.StoreRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StoreReportServiceImpl implements StoreReportService {

    private final StoreRepository storeRepository;

    @Override
    public List<ReportEmployeeSalariesByPointOfSaleResponseDto> getReportEmployeeSalariesByPointOfSale() {
        List<Tuple> results = storeRepository.reportReportEmployeeSalariesByPointOfSale();
        return results.stream()
                .map(tuple -> new ReportEmployeeSalariesByPointOfSaleResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, Long.class),
                        tuple.get(2, BigDecimal.class)))
                .collect(Collectors.toList());

    }
}
