package com.example.employee.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.employee.model.Position}
 */
public record PositionUpdateRequestDto(Long id, String positionName, BigDecimal salary) {
}