package com.example.product.dto;

/**
 * DTO for {@link com.example.product.model.ProductType}
 */
public record ProductTypeUpdateRequestDto(Long id, String typeName, String description) {
}