package com.example.employee.mapper;

import com.example.employee.dto.PositionCreateRequestDto;
import com.example.employee.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PositionCreateMapper {


    Position toEntity(PositionCreateRequestDto positionCreateRequestDto);

    PositionCreateRequestDto toPositionCreateRequestDto(Position position);
}