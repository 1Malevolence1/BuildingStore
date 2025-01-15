package com.example.employee.service;

import com.example.employee.dto.PositionCreateRequestDto;
import com.example.employee.dto.PositionResponseDto;
import com.example.employee.dto.PositionUpdateRequestDto;

import java.util.List;

public interface PositionService {

    void createPosition(PositionCreateRequestDto dto);
    void updatePosition(PositionUpdateRequestDto dto);
    void deletePosition(Long positionId);
    List<PositionResponseDto> getAll();
}
