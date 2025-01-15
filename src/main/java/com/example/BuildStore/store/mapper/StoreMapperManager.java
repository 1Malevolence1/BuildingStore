package com.example.store.mapper;

import com.example.store.model.Store;
import com.example.store.store.StoreCreateDtoRequest;
import com.example.store.store.StoreResponseDto;
import com.example.store.store.StoreUpdateDtoRequest;

import java.util.List;

public interface StoreMapperManager {

    Store toModel(StoreCreateDtoRequest dto);
    Store toModel(StoreUpdateDtoRequest dto);

    StoreResponseDto toDto(Store model);
    List<StoreResponseDto> toListDto(List<Store> model);
}
