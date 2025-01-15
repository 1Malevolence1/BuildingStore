package com.example.store.store;

/**
 * DTO for {@link com.example.store.model.Store}
 */
public record StoreUpdateDtoRequest(Long id, String storeName, String location) {
}