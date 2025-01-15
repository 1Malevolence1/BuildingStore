package com.example.sale.controller;


import com.example.customers.dto.CustomerCreateRequestDto;
import com.example.customers.dto.CustomerResponseDto;
import com.example.customers.dto.CustomerUpdateRequestDto;
import com.example.sale.dto.SaleCreateRequestDto;
import com.example.sale.dto.SaleResponseDto;
import com.example.sale.dto.SaleUpdateRequestDto;
import com.example.sale.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/sale")
@RequiredArgsConstructor
@Slf4j
public class SaleRestController {

    private final SaleService saleService;



    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<SaleResponseDto>> getAll() {
        log.info("начался метод по получению всех sale");
        return ResponseEntity.ok(
                saleService.getAllSales()
        );
    }

    @GetMapping("/{saleId:\\d+}")
    public ResponseEntity<SaleResponseDto> getSale(@PathVariable(name = "saleId") Long saleId) {
        log.info("начался метод по получению sale по ID::%d".formatted(saleId));
        return ResponseEntity.ok(
                saleService.getSale(saleId)
        );
    }

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Void> addSale(@RequestBody SaleCreateRequestDto dto) {
        log.info("начался метод по добавлению всех sale");
        log.info("{}", dto);
        saleService.createSale(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public ResponseEntity<Void> updateSale(@RequestBody SaleUpdateRequestDto dto) {
        log.info("начался метод по обновлению sale по ID::%d".formatted(dto.id()));
        log.info("{}", dto);
        saleService.updateSale(dto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("*")
    @PostMapping("/{saleId:\\d+}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "saleId") Long saleId) {
        log.info("начался метод по удалению sale с ID::%d".formatted(saleId));
        saleService.deleteSale(saleId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerSqlExceptionHelper(NoSuchElementException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
