package com.example.store.mapper;

import com.example.store.model.Store;
import com.example.store.store.StoreCreateDtoRequest;
import com.example.store.store.StoreResponseDto;
import com.example.store.store.StoreUpdateDtoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class StoreMapperManagerImpl implements StoreMapperManager {

    private final StoreMapper storeMapper;
    private final StoreListMapper storeListMapper;

    @Override
    public Store toModel(StoreCreateDtoRequest dto) {
        return storeMapper.toEntity(dto);
    }

    @Override
    public Store toModel(StoreUpdateDtoRequest dto) {
        return storeMapper.toEntity(dto);
    }

    @Override
    public StoreResponseDto toDto(Store model) {
        return storeMapper.toDto(model);
    }

    @Override
    public List<StoreResponseDto> toListDto(List<Store> model) {
        return storeListMapper.toDto(model);
    }


}
