package com.example.employee.mapper;

import com.example.employee.dto.EmployeeCreateRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.dto.EmployeeUpdateRequestDto;
import com.example.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class EmployeeManagerMapperImpl implements EmployeeManagerMapper {

    private final EmployeeMapper employeeMapper;
    private final EmployeeListMapper employeeListMapper;

    @Override
    public Employee toModel(EmployeeCreateRequestDto dto) {
        return employeeMapper.toEntity(dto);
    }


    @Override
    public List<EmployeeResponseDto> toDto(List<Employee> model) {
        return employeeListMapper.toDto(model);
    }
}
