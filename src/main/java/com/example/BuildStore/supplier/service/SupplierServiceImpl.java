package com.example.supplier.service;

import com.example.order.service.OrderService;
import com.example.product.service.ProductService;
import com.example.supplier.dto.SupplierCreateRequestDto;
import com.example.supplier.dto.SupplierUpdateRequestDto;
import com.example.supplier.model.Supplier;
import com.example.supplier.repository.SupplierRepository;
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
public class SupplierServiceImpl implements SupplierService {


    private final SupplierRepository supplierRepository;
    private final ProductService productService;
    private final OrderService orderService;


    @Override
    public void add(SupplierCreateRequestDto dto) {
        orderService.checkOrderById(dto.orderId());
        productService.getEntityProduct(dto.productId());
        supplierRepository.save(
                new Supplier(
                        null,
                        dto.supplyDate(),
                        dto.quantity(),
                        dto.productId(),
                        dto.orderId()
                )
        );
    }

    @Override
    public void update(SupplierUpdateRequestDto dto) {
        orderService.checkOrderById(dto.orderId());
        productService.getEntityProduct(dto.productId());

        supplierRepository.findById(dto.id()).ifPresentOrElse(
                supplier -> {
                    supplier.setSupplyDate(dto.supplyDate());
                    supplier.setQuantity(dto.quantity());
                    supplier.setProductId(dto.productId());
                    supplier.setOrderId(dto.orderId());
                }, () -> {
                    throw new NoSuchElementException("Not found Supplier with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void delete(Long supplierId) {
        supplierRepository.deleteById(supplierId);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }
}
