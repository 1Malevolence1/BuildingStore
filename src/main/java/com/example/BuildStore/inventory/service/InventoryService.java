package com.example.inventory.service;

import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.dto.InventoryCreateRequestDto;
import com.example.inventory.dto.InventoryUpdateRequestDto;

import java.util.List;

public interface InventoryService {

    void addInventory(InventoryCreateRequestDto dto);
    void updateInventory(InventoryUpdateRequestDto dto);
    void deleteInventory(Long inventoryId);
    List<InventoryResponseDto> getAll();
}
