package com.example.customers.mapper;

import com.example.customers.model.Customer;
import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;

import java.util.List;

public interface CustomerMapperManager {

    Customer toModel(CustomerCreateRequestDto dto);
    Customer toModel(CustomerUpdateRequestDto dto);

    CustomerResponseDto toDto(Customer model);

    List<CustomerResponseDto> toListDto(List<Customer> model);
}
