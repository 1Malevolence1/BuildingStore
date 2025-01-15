package com.example.customers.dto;

/**
 * DTO for {@link com.example.customers.model.Customer}
 */
public record CustomerCreateRequestDto(String fullName, String phone, String email, String address) {
}