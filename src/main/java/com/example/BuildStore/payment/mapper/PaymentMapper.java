package com.example.payment.mapper;

import com.example.payment.dto.PaymentCreateRequestDto;
import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    Payment toEntity(PaymentCreateRequestDto paymentCreateRequestDto);

    PaymentCreateRequestDto toPaymentCreateRequestDto(Payment payment);

    Payment toEntity(PaymentResponseDto paymentResponseDto);

    PaymentResponseDto toPaymentResponseDto(Payment payment);
}