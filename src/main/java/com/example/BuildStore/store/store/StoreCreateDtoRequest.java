package com.example.store.store;

/**
 * DTO for {@link com.example.store.model.Store}
 */
public record StoreCreateDtoRequest(String storeName, String location) {
}