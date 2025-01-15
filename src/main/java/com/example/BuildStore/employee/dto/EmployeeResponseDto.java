package com.example.employee.dto;

import com.example.store.store.StoreResponseDto;

/**
 * DTO for {@link com.example.employee.model.Employee}
 */
public record EmployeeResponseDto(Long id, String FullName, PositionResponseDto position, StoreResponseDto store) {
}