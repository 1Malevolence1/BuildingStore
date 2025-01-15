package com.example.product.service;

import com.example.product.convert.ProductTypeManager;
import com.example.product.dto.*;
import com.example.product.repository.ProductTypeRepository;
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
public class ProductTypeServiceImpl implements ProductTypeService {


    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeManager productTypeManager;


    @Override
    public void createProductType(ProductTypeCreateRequestDto dto) {
        productTypeRepository.save(
                productTypeManager.toModel(dto)
        );
    }

    @Override
    public void updateProductType(ProductTypeUpdateRequestDto dto) {
        productTypeRepository.findById(dto.id()).ifPresentOrElse(
                productType ->{
                    productType.setTypeName(dto.typeName());
                    productType.setDescription(dto.description());
                }, () -> {
                    throw new NoSuchElementException("Not found productType with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void deleteProductType(Long prodcutTypeId) {
        productTypeRepository.deleteById(prodcutTypeId);
    }

    @Override
    public List<ProductTypeDto> getAll() {
        return productTypeManager.toDto(
                productTypeRepository.findAll()
        );
    }
}
