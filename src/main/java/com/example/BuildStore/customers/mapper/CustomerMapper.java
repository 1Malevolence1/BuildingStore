package com.example.customers.mapper;

import com.example.customers.model.Customer;
import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toEntity(CustomerCreateRequestDto customerCreateRequestDto);

    CustomerCreateRequestDto toCustomerCreateRequestDto(Customer customer);

    Customer toEntity(CustomerUpdateRequestDto customerUpdateRequestDto);

    CustomerUpdateRequestDto toCustomerUpdateRequestDto(Customer customer);

    Customer toEntity(CustomerResponseDto customerResponseDto);

    CustomerResponseDto toCustomerResponseDto(Customer customer);
}