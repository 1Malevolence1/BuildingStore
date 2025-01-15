package com.example.customers.mapper;

import com.example.customers.model.Customer;
import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;




@Component
@RequiredArgsConstructor
public class CustomerMapperManagerImpl implements CustomerMapperManager {

    private final CustomerMapper customerMapper;
    private final CustomerListMapper customerListMapper;

    @Override
    public Customer toModel(CustomerCreateRequestDto dto) {
        return customerMapper.toEntity(dto);
    }

    @Override
    public Customer toModel(CustomerUpdateRequestDto dto) {
        return customerMapper.toEntity(dto);
    }

    @Override
    public CustomerResponseDto toDto(Customer model) {
        return customerMapper.toCustomerResponseDto(model);
    }

    @Override
    public List<CustomerResponseDto> toListDto(List<Customer> model) {
        return customerListMapper.toDto(model);
    }
}
