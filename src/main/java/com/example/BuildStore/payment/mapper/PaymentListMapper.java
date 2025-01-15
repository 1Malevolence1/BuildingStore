package com.example.payment.mapper;

import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.model.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PaymentMapper.class)
public interface PaymentListMapper {

    List<PaymentResponseDto> toDto(List<Payment> model);
}
