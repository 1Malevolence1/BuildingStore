package com.example.payment.mapper;

import com.example.payment.dto.PaymentCreateRequestDto;
import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentManagerMapperImpl implements PaymentManagerMapper {

    private final PaymentMapper paymentMapper;
    private final PaymentListMapper paymentListMapper;

    @Override
    public Payment toModel(PaymentCreateRequestDto dto) {
        return paymentMapper.toEntity(dto);
    }


    @Override
    public List<PaymentResponseDto> toDto(List<Payment> model) {
        return paymentListMapper.toDto(model);
    }
}
