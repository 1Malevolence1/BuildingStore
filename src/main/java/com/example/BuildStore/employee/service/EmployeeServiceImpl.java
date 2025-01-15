package com.example.employee.service;

import com.example.employee.dto.EmployeeCreateRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.dto.EmployeeUpdateRequestDto;
import com.example.employee.exception.EmployeeNotFoundPositionException;
import com.example.employee.mapper.EmployeeManagerMapper;
import com.example.employee.model.Position;
import com.example.employee.repository.EmployeeRepository;
import com.example.store.model.Store;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeManagerMapper employeeManagerMapper;

    @Override
    public void createEmployee(EmployeeCreateRequestDto dto) {
    try {
        employeeRepository.save(
                employeeManagerMapper.toModel(dto)
        );
    } catch (DataIntegrityViolationException exception){
        throw new EmployeeNotFoundPositionException("позиции с ID::%d нет базе данных".formatted(dto.positionId()));
    }

    }

    @Override
    public void updateEmployee(EmployeeUpdateRequestDto dto) {
        employeeRepository.findById(dto.id()).ifPresentOrElse(
                employee -> {
                    employee.setFullName(dto.FullName());
                    employee.setPosition(Position.builder().id(dto.positionId()).build());
                    employee.setStore(Store.builder().id(dto.storeId()).build());
                }, () -> {
                    throw new NoSuchElementException("Not found employee with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeManagerMapper.toDto(
                employeeRepository.findAll()
        );
    }
}
