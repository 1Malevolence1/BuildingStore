package com.example.orderDetails.service;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import com.example.orderDetails.dto.OrderDetailCreateRequestDto;
import com.example.orderDetails.dto.OrderDetailUpdateRequestDto;
import com.example.orderDetails.dto.OrderDetailesResponsetDto;
import com.example.orderDetails.mapper.OrderDetailsManagerMapper;
import com.example.orderDetails.repository.OrderDetailRepository;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
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
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailsManagerMapper mapper;
    private final ProductService productService;
    private final OrderService orderService;

    @Override
    public void add(OrderDetailCreateRequestDto dto) {
            orderService.checkOrderById(dto.orderId());
            productService.getEntityProduct(dto.productId());
            orderDetailRepository.save(
               mapper.toModel(
                       dto
               )
            );
    }

    @Override
    public void update(OrderDetailUpdateRequestDto dto) {
            orderDetailRepository.findById(dto.id()).ifPresentOrElse(
                    orderDetails -> {
                        orderDetails.setOrder(Order.builder().id(dto.orderId()).build());
                        orderDetails.setProduct(Product.builder().id(dto.productId()).build());
                        orderDetails.setQuantity(dto.quantity());
                    }, () -> {
                        throw new NoSuchElementException("Not found orderDetails with ID::%d".formatted(dto.id()));
                    }
            );
    }

    @Override
    public void delete(Long orderDetailsId) {
        orderDetailRepository.deleteById(orderDetailsId);
    }

    @Override
    public List<OrderDetailesResponsetDto> getAll() {
        return mapper.toDto(
                orderDetailRepository.findAll()
        );
    }
}
