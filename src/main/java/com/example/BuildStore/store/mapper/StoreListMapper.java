package com.example.store.mapper;


import com.example.store.model.Store;
import com.example.store.store.StoreResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = StoreMapper.class)
public interface StoreListMapper {

    List<StoreResponseDto> toDto(List<Store> model);
}
