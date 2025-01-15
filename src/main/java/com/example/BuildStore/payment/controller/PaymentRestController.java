package com.example.payment.controller;


import com.example.payment.dto.PaymentCreateRequestDto;
import com.example.payment.dto.PaymentResponseDto;
import com.example.payment.dto.PaymentUpdateRequestDto;
import com.example.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentRestController {

    private final PaymentService paymentService;


    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<PaymentResponseDto>> getAll() {
        log.info("начался метод по получению всех payment");
        return ResponseEntity.ok(
                paymentService.getAll()
        );
    }


    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody PaymentCreateRequestDto dto) {
        log.info("начался метод по добавлению нового payment");
        log.info("{}", dto);
        paymentService.add(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody PaymentUpdateRequestDto dto) {
        log.info("начался метод по обновлению payment");
        log.info("{}", dto);
        paymentService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{paymentId:\\d+}/delete")
    public ResponseEntity<Void> delete(@PathVariable(name = "paymentId") Long paymentId) {
        log.info("начался метод по удалению payment с ID::%d".formatted(paymentId));
        paymentService.delete(paymentId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
