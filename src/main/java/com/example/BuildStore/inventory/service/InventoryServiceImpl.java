package com.example.inventory.service;

import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.dto.InventoryCreateRequestDto;
import com.example.inventory.dto.InventoryUpdateRequestDto;
import com.example.inventory.mapper.InventoryMapperManager;
import com.example.inventory.model.Inventory;
import com.example.inventory.repository.InventoryRepository;
import com.example.product.model.Product;
import com.example.store.model.Store;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InventoryServiceImpl implements InventoryService {


    private final InventoryRepository inventoryRepository;
    private final InventoryMapperManager inventoryMapperManager;

    @Override
    public void addInventory(InventoryCreateRequestDto dto) {
            if(dto.productId() == null) throw new NullPointerException("productId равно null в методе сохранения");
            inventoryRepository.save(
                    inventoryMapperManager.toModel(
                            dto
                    )
            );
    }

    @Override
    public void updateInventory(InventoryUpdateRequestDto dto) {
        if (dto.productId() == null) {
            throw new IllegalArgumentException("productId равно null в методе обновления");
        }
        if (dto.id() == null) {
            throw new IllegalArgumentException("id равно null в методе обновления");
        }

        Inventory existingInventory = inventoryRepository.findById(dto.id())
                .orElseThrow(() -> new NoSuchElementException("Inventory с id " + dto.id() + " не найден"));


        existingInventory.setQuantity(dto.quantity());
        existingInventory.setProduct(Product.builder().id(dto.productId()).build());
        existingInventory.setStore(Store.builder().id(dto.storeId()).build());
        existingInventory.setDate(dto.date());

        inventoryRepository.save(existingInventory);
    }

    @Override
    public void deleteInventory(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }

    @Override
    public List<InventoryResponseDto> getAll() {
        return inventoryMapperManager.toDto(
                inventoryRepository.findAll()
        );
    }
}
