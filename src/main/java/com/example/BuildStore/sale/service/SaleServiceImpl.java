package com.example.sale.service;

import com.example.customers.model.Customer;
import com.example.customers.service.CustomerService;
import com.example.sale.dto.SaleCreateRequestDto;
import com.example.sale.dto.SaleResponseDto;
import com.example.sale.dto.SaleUpdateRequestDto;
import com.example.sale.mapper.SaleManagerMapper;
import com.example.sale.model.Sale;
import com.example.sale.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleManagerMapper saleManagerMapper;
    private final CustomerService customerService;

    @Override
    public void createSale(SaleCreateRequestDto dto) {
            customerService.getEntityCustomer(dto.customerId());
            saleRepository.save(
                    saleManagerMapper.toModel(dto)
            );
    }

    @Override
    public void updateSale(SaleUpdateRequestDto dto) {
        Customer customer = customerService.getEntityCustomer(dto.customerId());

        saleRepository.findById(dto.id()).ifPresentOrElse(
                sale -> {
                    sale.setSaleDate(dto.saleDate());
                    sale.setTotalAmount(dto.totalAmount());
                    sale.setCustomer(customer);
                }, () -> {
                    throw new NoSuchElementException("Not fount sale with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }

    @Override
    public SaleResponseDto getSale(Long saleId) {
        return saleManagerMapper.toDto(saleRepository.findById(saleId).orElseThrow(
                () -> new NoSuchElementException("Not fount sale with ID::%d".formatted(saleId)
                )));
    }

    @Override
    public Sale getEntitySale(Long saleId) {
        return saleRepository.findById(saleId).orElseThrow(() -> new NoSuchElementException("Not fount sale with ID::%d".formatted(saleId)));
    }

    @Override
    public List<SaleResponseDto> getAllSales() {
        return saleManagerMapper.toListDto(
                saleRepository.findAll()
        );
    }
}
