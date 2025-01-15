package com.example.store.mapper;

import com.example.store.model.Store;
import com.example.store.store.StoreCreateDtoRequest;
import com.example.store.store.StoreResponseDto;
import com.example.store.store.StoreUpdateDtoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StoreMapper {
    Store toEntity(StoreCreateDtoRequest storeCreateDtoRequest);

    StoreCreateDtoRequest toStoreCreateDtoRequest(Store store);

    Store toEntity(StoreUpdateDtoRequest storeUpdateDtoRequest);

    StoreUpdateDtoRequest toStoreUpdateDtoRequest(Store store);

    StoreResponseDto toDto(Store model);

    Store toEntity(StoreResponseDto storeResponseDto);
}