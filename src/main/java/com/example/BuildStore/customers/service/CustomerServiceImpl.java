package com.example.customers.service;

import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;
import com.example.customers.mapper.CustomerMapperManager;
import com.example.customers.model.Customer;
import com.example.customers.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapperManager customerMapperManager;

    @Override
    public void createCustomer(CustomerCreateRequestDto dto) {
        customerRepository.save(
                customerMapperManager.toModel(dto)
        );
    }

    @Override
    public void updateCustomer(CustomerUpdateRequestDto dto) {
        customerRepository.findById(dto.id()).ifPresentOrElse(
                customer -> {
                    customer.setFullName(dto.fullName());
                    customer.setPhone(dto.phone());
                    customer.setAddress(dto.address());
                    customer.setEmail(dto.email());
                }, () -> {
                    throw new NoSuchElementException("Not found customer with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getEntityCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow( () -> new NoSuchElementException("Not found customer with ID::%d".formatted(customerId)));
    }

    @Override
    public CustomerResponseDto getCustomer(Long customerId) {
        return customerMapperManager.toDto(
                customerRepository.findById(customerId)
                        .orElseThrow(() -> new NoSuchElementException("Not found customer with ID::%d".formatted(customerId)))
        );
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        return customerMapperManager.toListDto(
                customerRepository.findAll()
        );
    }
}
