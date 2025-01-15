package com.example.sale.service;

import com.example.sale.dto.SaleCreateRequestDto;
import com.example.sale.dto.SaleResponseDto;
import com.example.sale.dto.SaleUpdateRequestDto;
import com.example.sale.model.Sale;

import java.util.List;

public interface SaleService {

    void createSale(SaleCreateRequestDto dto);
    void updateSale(SaleUpdateRequestDto dto);
    void deleteSale(Long saleId);
    SaleResponseDto getSale(Long saleId);
    Sale getEntitySale(Long saleId);
    List<SaleResponseDto> getAllSales();


}
