package com.example.employee.mapper;

import com.example.employee.dto.EmployeeCreateRequestDto;
import com.example.employee.dto.PositionResponseDto;
import com.example.employee.model.Employee;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    @Mapping(source = "storeId", target = "store.id")
    @Mapping(source = "positionId", target = "position.id")
    Employee toEntity(EmployeeCreateRequestDto employeeCreateRequestDto);

    @InheritInverseConfiguration(name = "toEntity")
    EmployeeCreateRequestDto toEmployeeCreateRequestDto(Employee employee);

    Employee toEntity(PositionResponseDto positionResponseDto);

    PositionResponseDto toPositionResponseDto(Employee employee);
}