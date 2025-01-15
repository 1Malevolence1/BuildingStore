package com.example.order.controller;


import com.example.order.dto.OrderCreateRequestDto;
import com.example.order.dto.OrderResponseDto;
import com.example.order.dto.OrderUpdateRequestDto;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderRestController {

    private final OrderService orderService;


    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<OrderResponseDto>> getAll() {
        log.info("начался метод по получению всех orders");
        return ResponseEntity.ok(
                orderService.getAll()
        );
    }


    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody OrderCreateRequestDto dto) {
        log.info("начался метод по добавлению нового order");
        log.info("{}", dto);
        orderService.create(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody OrderUpdateRequestDto dto) {
        log.info("начался метод по обновлению order");
        log.info("{}", dto);
        orderService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{orderId:\\d+}/delete")
    public ResponseEntity<Void> delete(@PathVariable(name = "orderId") Long orderId) {
        log.info("начался метод по удалению order с ID::%d".formatted(orderId));
        orderService.delete(orderId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
