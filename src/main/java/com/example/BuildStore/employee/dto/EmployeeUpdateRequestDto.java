package com.example.employee.dto;

import com.example.store.model.Store;
import com.example.store.store.StoreResponseDto;

/**
 * DTO for {@link com.example.employee.model.Employee}
 */
public record EmployeeUpdateRequestDto(Long id, String FullName, Long positionId, Long storeId) {
}