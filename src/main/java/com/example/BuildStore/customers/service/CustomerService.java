package com.example.customers.service;


import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;
import com.example.customers.model.Customer;

import java.util.List;

public interface CustomerService {

    void createCustomer(CustomerCreateRequestDto dto);
    void updateCustomer(CustomerUpdateRequestDto dto);
    void deleteCustomer(Long customerId);
    Customer getEntityCustomer(Long customerId);
    CustomerResponseDto getCustomer(Long customerId);
    List<CustomerResponseDto> getAllCustomers();
}
