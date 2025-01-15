package com.example.inventory.mapper;

import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.dto.InventoryCreateRequestDto;
import com.example.inventory.dto.InventoryUpdateRequestDto;
import com.example.inventory.model.Inventory;

import java.util.List;

public interface InventoryMapperManager {
    Inventory toModel(InventoryCreateRequestDto dto);
    Inventory toModel(InventoryUpdateRequestDto dto);

    List<InventoryResponseDto> toDto(List<Inventory> model);
}
