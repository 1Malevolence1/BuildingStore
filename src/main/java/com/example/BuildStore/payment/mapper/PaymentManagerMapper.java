package com.example.payment.mapper;

import com.example.payment.dto.PaymentCreateRequestDto;
import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.model.Payment;

import java.util.List;

public interface PaymentManagerMapper {

    Payment toModel(PaymentCreateRequestDto dto);


    List<PaymentResponseDto> toDto(List<Payment> model);
}
