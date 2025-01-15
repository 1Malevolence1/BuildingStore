package com.example.employee.dto;

/**
 * DTO for {@link com.example.employee.model.Employee}
 */
public record EmployeeCreateRequestDto(String FullName, Long positionId, Long storeId) {
}