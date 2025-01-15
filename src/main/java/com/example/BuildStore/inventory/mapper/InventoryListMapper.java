package com.example.inventory.mapper;


import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.model.Inventory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = InventoryMapper.class)
public interface InventoryListMapper {


    List<InventoryResponseDto> toDto(List<Inventory> model);
}
