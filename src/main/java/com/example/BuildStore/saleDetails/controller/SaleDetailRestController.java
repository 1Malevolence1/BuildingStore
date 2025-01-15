package com.example.saleDetails.controller;


import com.example.saleDetails.dto.SaleDetailCreateRequestDto;
import com.example.saleDetails.dto.SaleDetailResponseDto;
import com.example.saleDetails.dto.SaleDetailUpdateRequestDto;
import com.example.saleDetails.service.SaleDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/saleDetail")
@RequiredArgsConstructor
@Slf4j
public class SaleDetailRestController {

    private final SaleDetailService saleDetailService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<SaleDetailResponseDto>> getAll() {
        log.info("начался метод по получению всех saleDetails");
        return ResponseEntity.ok(
                saleDetailService.getAll()
        );
    }

    @GetMapping("/{saleDetailId:\\d+}")
    public ResponseEntity<SaleDetailResponseDto> getCustomer(@PathVariable(name = "saleDetailId") Long saleDetailId) {
        log.info("начался метод по получению saleDetail по ID::%d".formatted(saleDetailId));
        return ResponseEntity.ok(
                saleDetailService.get(saleDetailId)
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addEmployee(@RequestBody SaleDetailCreateRequestDto dto) {
        log.info("начался метод по добавлению sale");
        log.info("{}", dto);
        saleDetailService.create(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody SaleDetailUpdateRequestDto dto) {
        log.info("начался метод по обновлению saleDetails");
        log.info("{}", dto);
        saleDetailService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{saleDetailId:\\d+}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "saleDetailId") Long saleDetailId) {
        log.info("начался метод по удалению клиента с ID::%d".formatted(saleDetailId));
        saleDetailService.get(saleDetailId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
