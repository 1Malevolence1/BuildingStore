package com.example.supplier.service;

import com.example.supplier.dto.SupplierCreateRequestDto;
import com.example.supplier.dto.SupplierUpdateRequestDto;
import com.example.supplier.model.Supplier;

import java.util.List;

public interface SupplierService {

    void add(SupplierCreateRequestDto dto);
    void update(SupplierUpdateRequestDto dto);
    void delete(Long supplierId);
    List<Supplier> getAll();
}
