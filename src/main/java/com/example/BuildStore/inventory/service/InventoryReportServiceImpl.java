package com.example.inventory.service;

import com.example.inventory.repository.InventoryRepository;
import com.example.report.dto.ReportByPointOfStoreResponseDto;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InventoryReportServiceImpl implements InventoryReportService {

    private final InventoryRepository inventoryRepository;

    @Override
    public List<ReportByPointOfStoreResponseDto> findReportByPointOfStore() {
        List<Tuple> results = inventoryRepository.reportReportByPointOfStore();
        return results.stream()
                .map(tuple -> new ReportByPointOfStoreResponseDto(
                        tuple.get(0, String.class),
                        tuple.get(1, String.class),
                        tuple.get(2, Long.class)))
                .collect(Collectors.toList());
    }
}
