package com.example.payment.service;

import com.example.payment.dto.PaymentCreateRequestDto;
import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.dto.PaymentUpdateRequestDto;

import java.util.List;

public interface PaymentService {

    void add(PaymentCreateRequestDto dto);
    void update(PaymentUpdateRequestDto dto);
    void delete(Long id);
    List<PaymentResponseDto> getAll();
}
