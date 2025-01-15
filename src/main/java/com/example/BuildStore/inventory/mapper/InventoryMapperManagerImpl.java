package com.example.inventory.mapper;

import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.dto.InventoryCreateRequestDto;
import com.example.inventory.dto.InventoryUpdateRequestDto;
import com.example.inventory.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class InventoryMapperManagerImpl implements InventoryMapperManager {

    private final InventoryMapper inventoryMapper;
    private final InventoryListMapper inventoryListMapper;

    @Override
    public Inventory toModel(InventoryCreateRequestDto dto) {
        return inventoryMapper.toEntity(dto);
    }

    @Override
    public Inventory toModel(InventoryUpdateRequestDto dto) {
        return inventoryMapper.toEntity(dto);
    }

    @Override
    public List<InventoryResponseDto> toDto(List<Inventory> model) {
        return inventoryListMapper.toDto(model);
    }
}
