package com.example.employee.mapper;

import com.example.employee.dto.PositionUpdateRequestDto;
import com.example.employee.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionUpdateMapper {
    Position toEntity(PositionUpdateRequestDto positionUpdateRequestDto);

    PositionUpdateRequestDto toPositionUpdateRequestDto(Position position);
}