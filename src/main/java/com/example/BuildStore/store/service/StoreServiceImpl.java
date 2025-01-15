package com.example.store.service;

import com.example.store.mapper.StoreMapperManager;
import com.example.store.repository.StoreRepository;
import com.example.store.store.StoreCreateDtoRequest;
import com.example.store.store.StoreResponseDto;
import com.example.store.store.StoreUpdateDtoRequest;
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
public class StoreServiceImpl implements StoreService {

    private final StoreMapperManager storeMapperManager;
    private final StoreRepository storeRepository;

    @Override
    public void createStore(StoreCreateDtoRequest dto) {
        storeRepository.save(
                storeMapperManager.toModel(dto)
        );
    }

    @Override
    public void updateStore(StoreUpdateDtoRequest dto) {
        storeRepository.findById(dto.id()).ifPresentOrElse(
                store -> {
                    store.setStoreName(dto.storeName());
                    store.setLocation(dto.location());
                }, () -> {
                    throw new NoSuchElementException("Not found store with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void deleteStore(Long storeId) {
        storeRepository.deleteById(storeId);
    }

    @Override
    public List<StoreResponseDto> getAll() {
        return storeMapperManager.toListDto(
                storeRepository.findAll()
        );
    }

    @Override
    public StoreResponseDto getStore(Long storeId) {
        return storeMapperManager.toDto
                (storeRepository.findById(storeId).orElseThrow(()
                -> new NoSuchElementException("Not found store with ID::%d".formatted(storeId))));

    }

    @Override
    public void checkStoreById(Long storeId) {
        if(!storeRepository.existsById(storeId)) {
            throw new NoSuchElementException("Not found store with ID::%d".formatted(storeId));
        }
    }
}
