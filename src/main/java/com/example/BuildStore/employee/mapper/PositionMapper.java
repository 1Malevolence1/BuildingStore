package com.example.employee.mapper;

import com.example.employee.dto.PositionResponseDto;
import com.example.employee.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionMapper {
    Position toEntity(PositionResponseDto positionResponseDto);

    PositionResponseDto toPositionResponseDto(Position position);
}