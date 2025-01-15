package com.example.store.service;

import com.example.store.store.StoreCreateDtoRequest;
import com.example.store.store.StoreResponseDto;
import com.example.store.store.StoreUpdateDtoRequest;

import java.util.List;

public interface StoreService {

    void createStore(StoreCreateDtoRequest dto);
    void updateStore(StoreUpdateDtoRequest dto);
    void deleteStore(Long storeId);
    List<StoreResponseDto> getAll();
    StoreResponseDto getStore(Long storeId);
    void checkStoreById(Long storeId);
}
