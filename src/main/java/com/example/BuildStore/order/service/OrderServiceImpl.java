package com.example.order.service;

import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.dto.OrderUpdateRequestDto;
import com.example.order.mapper.OrderManagerMapper;
import com.example.order.repository.OrderRepository;
import com.example.store.model.Store;
import com.example.store.service.StoreService;
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
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StoreService storeService;
    private final OrderManagerMapper orderManagerMapper;

    @Override
    public void create(OrderCreateRequestDto dto) {
        storeService.checkStoreById(dto.storeId());
        orderRepository.save(
                orderManagerMapper.toModel(dto)
        );
    }

    @Override
    public void update(OrderUpdateRequestDto dto) {
        orderRepository.findById(dto.id()).ifPresentOrElse(
                order -> {
                    order.setOrderDate(dto.orderDate());
                    order.setStatus(dto.status());
                    order.setStore(Store.builder().id(dto.storeId()).build());
                }, () -> {
                    throw new NoSuchElementException("Not found order with ID::%d".formatted(dto.id()) );
                }
        );
    }

    @Override
    public void delete(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderResponseDto> getAll() {
        return orderManagerMapper.toDto(
                orderRepository.findAll()
        );
    }

    @Override
    public void checkOrderById(Long orderId) {
        if(!orderRepository.existsById(orderId)) {
            throw new NoSuchElementException("Not found order with ID::%d".formatted(orderId));
        }
    }
}
