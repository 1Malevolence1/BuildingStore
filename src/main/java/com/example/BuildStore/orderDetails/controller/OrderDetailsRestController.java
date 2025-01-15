package com.example.orderDetails.controller;


import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.dto.OrderUpdateRequestDto;
import com.example.orderDetails.dto.OrderDetailCreateRequestDto;
import com.example.orderDetails.dto.OrderDetailUpdateRequestDto;
import com.example.orderDetails.dto.OrderDetailesResponsetDto;
import com.example.orderDetails.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/orderDetails")
@RequiredArgsConstructor
@Slf4j
public class OrderDetailsRestController {


    private final OrderDetailService orderDetailService;


    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<OrderDetailesResponsetDto>> getAll() {
        log.info("начался метод по получению всех ordersDetails");
        return ResponseEntity.ok(
                orderDetailService.getAll()
        );
    }


    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody OrderDetailCreateRequestDto dto) {
        log.info("начался метод по добавлению нового orderDetails");
        log.info("{}", dto);
        orderDetailService.add(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody OrderDetailUpdateRequestDto dto) {
        log.info("начался метод по обновлению orderDetail");
        log.info("{}", dto);
        orderDetailService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{orderDetailId:\\d+}/delete")
    public ResponseEntity<Void> delete(@PathVariable(name = "orderDetailId") Long orderDetailId) {
        log.info("начался метод по удалению orderDetail с ID::%d".formatted(orderDetailId));
        orderDetailService.delete(orderDetailId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
