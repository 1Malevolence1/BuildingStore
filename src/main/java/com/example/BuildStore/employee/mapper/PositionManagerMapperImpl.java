package com.example.employee.mapper;

import com.example.employee.dto.PositionCreateRequestDto;
import com.example.employee.dto.PositionResponseDto;
import com.example.employee.dto.PositionUpdateRequestDto;
import com.example.employee.model.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class PositionManagerMapperImpl implements PositionManagerMapper {

    private final PositionCreateMapper createMapper;
    private final PositionUpdateMapper updateMapper;
    private final PositionListMapper positionMapper;


    @Override
    public Position toModel(PositionCreateRequestDto dto) {
        return createMapper.toEntity(dto);
    }

    @Override
    public Position toModel(PositionUpdateRequestDto dto) {
        return updateMapper.toEntity(dto);
    }

    @Override
    public List<PositionResponseDto> toDto(List<Position> model) {
        return positionMapper.toDto(model);
    }
}
