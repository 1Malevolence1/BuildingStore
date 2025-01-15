package com.example.payment.service;

import com.example.payment.dto.PaymentCreateRequestDto;
import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.dto.PaymentUpdateRequestDto;
import com.example.payment.mapper.PaymentManagerMapper;
import com.example.payment.repostiory.PaymentRepository;
import com.example.sale.service.SaleService;
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
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentManagerMapper paymentManagerMapper;
    private final SaleService saleService;


    @Override
    public void add(PaymentCreateRequestDto dto) {
            saleService.getEntitySale(dto.saleId());
            paymentRepository.save(
                    paymentManagerMapper.toModel(dto)
            );
    }

    @Override
    public void update(PaymentUpdateRequestDto dto) {
        saleService.getEntitySale(dto.saleId());
        paymentRepository.findById(dto.id()).ifPresentOrElse(
                payment -> {
                    payment.setPaymentDate(dto.paymentDate());
                    payment.setAmount(dto.amount());
                    payment.setSaleId(dto.saleId());
                }, () -> {
                    throw new NoSuchElementException("Not found payment with ID::%d".formatted(dto.id()));
                }
        );
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentResponseDto> getAll() {
        return paymentManagerMapper.toDto(
                paymentRepository.findAll()
        );
    }
}
