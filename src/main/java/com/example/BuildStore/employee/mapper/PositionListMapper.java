package com.example.employee.mapper;


import com.example.employee.dto.PositionResponseDto;
import com.example.employee.model.Position;
import com.example.inventory.dto.ResponseProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PositionMapper.class)
public interface PositionListMapper {

    List<PositionResponseDto> toDto(List<Position> model);
}
