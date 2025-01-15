package com.example.customers.dto;

/**
 * DTO for {@link com.example.customers.model.Customer}
 */
public record CustomerUpdateRequestDto(Long id, String fullName, String phone, String email, String address) {
}