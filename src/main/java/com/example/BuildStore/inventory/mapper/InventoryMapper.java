package com.example.inventory.mapper;

import com.example.inventory.dto.InventoryResponseDto;
import com.example.inventory.dto.InventoryCreateRequestDto;
import com.example.inventory.dto.InventoryUpdateRequestDto;
import com.example.inventory.model.Inventory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryMapper {
    @Mapping(source = "storeId", target = "store.id")
    @Mapping(source = "productId", target = "product.id")
    Inventory toEntity(InventoryCreateRequestDto inventoryCreateRequestDto);

    @Mapping(source = "store.id", target = "storeId")
    @Mapping(source = "product.id", target = "productId")
    InventoryCreateRequestDto toInventoryCreateRequestDto(Inventory inventory);


    @Mapping(source = "storeId", target = "store.id")
    @Mapping(source = "productId", target = "product.id")
    Inventory toEntity(InventoryUpdateRequestDto inventoryUpdateRequestDto);

    @Mapping(source = "store.id", target = "storeId")
    @Mapping(source = "product.id", target = "productId")
    InventoryUpdateRequestDto toInventoryUpdateRequestDto(Inventory inventory);


    InventoryResponseDto toInventoryDto(Inventory inventory);


    @InheritConfiguration(name = "toEntity")
    Inventory updateWithNull(InventoryCreateRequestDto inventoryCreateRequestDto, @MappingTarget Inventory inventory);
}