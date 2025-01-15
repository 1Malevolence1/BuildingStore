package com.example.customers.mapper;


import com.example.customers.model.Customer;
import com.example.customers.dto.CustomerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CustomerMapper.class)
public interface CustomerListMapper {

    List<CustomerResponseDto> toDto(List<Customer> model);
}
