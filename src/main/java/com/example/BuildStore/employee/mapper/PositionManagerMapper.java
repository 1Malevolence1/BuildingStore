package com.example.employee.mapper;

import com.example.employee.dto.PositionCreateRequestDto;
import com.example.employee.dto.PositionResponseDto;
import com.example.employee.dto.PositionUpdateRequestDto;
import com.example.employee.model.Position;

import java.util.List;

public interface PositionManagerMapper {

    Position toModel(PositionCreateRequestDto dto);
    Position toModel(PositionUpdateRequestDto dto);

    List<PositionResponseDto> toDto(List<Position> model);
}
