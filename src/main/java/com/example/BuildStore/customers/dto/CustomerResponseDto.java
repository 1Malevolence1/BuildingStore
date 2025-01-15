package com.example.customers.dto;

/**
 * DTO for {@link com.example.customers.model.Customer}
 */
public record CustomerResponseDto(Long id, String fullName, String phone, String email, String address) {
}