package com.example.employee.mapper;

import com.example.employee.dto.EmployeeCreateRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeManagerMapper {

    Employee toModel(EmployeeCreateRequestDto dto);

    List<EmployeeResponseDto> toDto(List<Employee> model);
}
