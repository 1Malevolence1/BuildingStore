package com.example.employee.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.employee.model.Position}
 */
public record PositionCreateRequestDto(String positionName, BigDecimal salary) {
}