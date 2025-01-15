package com.example.employee.service;

import com.example.employee.dto.PositionCreateRequestDto;
import com.example.employee.dto.PositionResponseDto;
import com.example.employee.dto.PositionUpdateRequestDto;
import com.example.employee.mapper.PositionManagerMapper;
import com.example.employee.repository.PositionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionManagerMapper positionManagerMapper;
    private final PositionRepository positionRepository;

    @Override
    public void createPosition(PositionCreateRequestDto dto) {
            positionRepository.save(
                    positionManagerMapper.toModel(dto)
            );
    }

    @Override
    public void updatePosition(PositionUpdateRequestDto dto) {
        positionRepository.findById(dto.id()).ifPresentOrElse(
                position -> {
                    position.setPositionName(dto.positionName());
                    position.setSalary(dto.salary());
                }, () -> {
                    throw new NoSuchElementException("Not found position with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void deletePosition(Long positionId) {
        positionRepository.deleteById(positionId);
    }

    @Override
    public List<PositionResponseDto> getAll() {
        return positionManagerMapper.toDto(
                positionRepository.findAll()
        );
    }
}
