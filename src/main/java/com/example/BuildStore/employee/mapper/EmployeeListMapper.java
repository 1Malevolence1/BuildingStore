package com.example.employee.mapper;


import com.example.employee.model.Employee;
import com.example.employee.dto.EmployeeResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface EmployeeListMapper {

    List<EmployeeResponseDto> toDto(List<Employee> model);
}
