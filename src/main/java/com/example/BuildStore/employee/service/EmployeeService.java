package com.example.employee.service;

import com.example.employee.dto.EmployeeCreateRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.dto.EmployeeUpdateRequestDto;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeCreateRequestDto dto);
    void updateEmployee(EmployeeUpdateRequestDto dto);
    void deleteEmployee(Long employeeId);
    List<EmployeeResponseDto> getAll();
}
